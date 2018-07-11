package br.com.kurtis.labs.service2;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@RestController
public class Service2Controller {

  private final Service2Client client;

  Service2Controller(Service2Client client) {
    this.client = client;
  }

  @GetMapping("/service2")
  Mono<String> service2() {
    log.info("getting response from service 2");
    final boolean goThrough3 = new Random().nextBoolean();
    return (goThrough3 ? this.client.callService3() : this.client.callService4())
        .map(service3or4 -> "service2 -> " + service3or4);
  }
}
