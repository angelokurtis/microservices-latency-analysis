package br.com.kurtis.labs.service1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
public class Service1Controller {

  private final Service1Client client;

  Service1Controller(Service1Client client) {
    this.client = client;
  }

  @GetMapping("/service1")
  Mono<String> service1() {
    log.info("getting response from service 1");
    return client.callService2().map(service2 -> "service1 -> " + service2);

  }
}
