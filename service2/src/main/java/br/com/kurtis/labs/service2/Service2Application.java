package br.com.kurtis.labs.service2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.Builder;

@SpringBootApplication
public class Service2Application {

  @Value("${SERVICE3_ADDRESS}")
  private String service3Address;
  @Value("${SERVICE4_ADDRESS}")
  private String service4Address;

  public static void main(String[] args) {
    SpringApplication.run(Service2Application.class, args);
  }

  @Bean
  Builder webClient3Builder() {
    return WebClient
        .builder()
        .baseUrl(service3Address);
  }

  @Bean
  Builder webClient4Builder() {
    return WebClient
        .builder()
        .baseUrl(service4Address);
  }
}

