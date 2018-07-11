package br.com.kurtis.labs.service2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class Service2Client {

  private final WebClient webClient3;
  private final WebClient webClient4;

  Service2Client(
      @Qualifier("webClient3Builder") WebClient.Builder webClientBuilder3,
      @Qualifier("webClient4Builder") WebClient.Builder webClientBuilder4) {
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
