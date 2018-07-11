package br.com.kurtis.labs.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

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

