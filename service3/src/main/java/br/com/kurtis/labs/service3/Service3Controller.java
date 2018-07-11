package br.com.kurtis.labs.service3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
public class Service3Controller {

  private final Service3Client client;

  Service3Controller(Service3Client client) {
    this.client = client;
  }

  @GetMapping("/service3")
  Mono<String> service3() {
    log.info("getting response from service 3");
    return client.callService2().map(service4 -> "service3 -> " + service4);
  }
}
