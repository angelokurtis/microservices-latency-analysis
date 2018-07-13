package br.com.kurtis.labs.service3;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@Log4j2
@SpringBootApplication
public class Service3Application {

  @Value("${SERVICE4_ADDRESS}")
  private String service4Address;

  public static void main(String[] args) {
    SpringApplication.run(Service3Application.class, args);
  }

  @Bean
  WebClient.Builder webClientBuilder() {
    log.info("service 3 address => " + this.service4Address);
    return WebClient
        .builder()
        .baseUrl(service4Address);
  }
}

