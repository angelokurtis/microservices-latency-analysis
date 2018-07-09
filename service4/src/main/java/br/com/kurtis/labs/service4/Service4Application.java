package br.com.kurtis.labs.service4;

import lombok.extern.log4j.Log4j2;
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

@Log4j2
@RestController
class Service4Controller {

  @GetMapping("/service4")
  Mono<String> service4() {
    log.info("getting response from service 4");
    return Mono.just("service 4");
  }
}