package br.com.kurtis.labs.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Service1Application {

  public static void main(String[] args) {
    SpringApplication.run(Service1Application.class, args);
  }

  @Bean
  WebClient.Builder webClientBuilder() {
    return WebClient
        .builder()
        .baseUrl("http://service2:8080");
  }
}

@RestController
class Service1Controller {

  private final Service1Client client;

  Service1Controller(Service1Client client) {
    this.client = client;
  }

  @GetMapping("/service1")
  Mono<String> service1() {
    return client.callService2().map(service2 -> "service1 -> " + service2);

  }
}

@Service
class Service1Client {

  private final WebClient webClient;

  Service1Client(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.build();
  }

  Mono<String> callService2() {
    return this.webClient.get()
        .uri("/service2")
        .retrieve()
        .bodyToMono(String.class);
  }
}