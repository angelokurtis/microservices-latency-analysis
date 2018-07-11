package br.com.kurtis.labs.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

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