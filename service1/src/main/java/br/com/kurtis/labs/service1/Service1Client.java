package br.com.kurtis.labs.service1;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class Service1Client {

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
