package br.com.kurtis.labs.service3;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class Service3Client {

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
