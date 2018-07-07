package br.com.kurtis.labs.service3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Service3Application {

  public static void main(String[] args) {
    SpringApplication.run(Service3Application.class, args);
  }

  @Bean
  WebClient.Builder webClientBuilder() {
    return WebClient
        .builder()
        .baseUrl("http://service4:8080");
  }
}

@RestController
class Service3Controller {

  private final Service3Client client;

  Service3Controller(Service3Client client) {
    this.client = client;
  }

  @GetMapping("/service3")
  Mono<String> service3() {
    return client.callService2().map(service4 -> "service3 -> " + service4);
  }
}

@Service
class Service3Client {

  private final WebClient webClient;

  Service3Client(WebClient.Builder webClientBuilder) {
    this.webClient = webClientBuilder.build();
  }

  Mono<String> callService2() {
    return this.webClient.get()
        .uri("/service4")
        .retrieve()
        .bodyToMono(String.class);
  }
}
