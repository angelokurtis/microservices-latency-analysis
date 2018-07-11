package br.com.kurtis.labs.service4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
public class Service4Controller {

  @GetMapping("/service4")
  Mono<String> service4() {
    log.info("getting response from service 4");
    return Mono.just("service 4");
  }
}
