package br.com.kurtis.labs.service2;

import java.util.Random;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Service2Application {

  public static void main(String[] args) {
    SpringApplication.run(Service2Application.class, args);
  }

  @Bean
  Builder webClient3Builder() {
    return WebClient
        .builder()
        .baseUrl("http://service3:8080");
  }

  @Bean
  Builder webClient4Builder() {
    return WebClient
        .builder()
        .baseUrl("http://service4:8080");
  }
}

@RestController
class Service2Controller {

  private final Service2Client client;

  Service2Controller(Service2Client client) {
    this.client = client;
  }

  @GetMapping("/service2")
  Mono<String> service2() {
    final boolean goThrough3 = new Random().nextBoolean();
    return (goThrough3 ? this.client.callService3() : this.client.callService4())
        .map(service3or4 -> "service2 -> " + service3or4);
  }
}

@Service
class Service2Client {

  private final WebClient webClient3;
  private final WebClient webClient4;

  Service2Client(
      @Qualifier("webClient3Builder") Builder webClientBuilder3,
      @Qualifier("webClient4Builder") Builder webClientBuilder4) {
    this.webClient3 = webClientBuilder3.build();
    this.webClient4 = webClientBuilder4.build();
  }

  Mono<String> callService3() {
    return this.webClient3.get()
        .uri("/service3")
        .retrieve()
        .bodyToMono(String.class);
  }

  Mono<String> callService4() {
    return this.webClient4.get()
        .uri("/service4")
        .retrieve()
        .bodyToMono(String.class);
  }
}