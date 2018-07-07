package br.com.kurtis.labs.service4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class Service4Application {

  public static void main(String[] args) {
    SpringApplication.run(Service4Application.class, args);
  }
}

@RestController
class Service4Controller {

  @GetMapping("/service4")
  Mono<String> service4() {
    return Mono.just("service 4");
  }
}