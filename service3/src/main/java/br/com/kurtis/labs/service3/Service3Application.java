package br.com.kurtis.labs.service3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

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

