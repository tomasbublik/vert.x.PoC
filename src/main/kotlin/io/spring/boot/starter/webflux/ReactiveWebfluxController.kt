package io.spring.boot.starter.webflux

import io.Logging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.net.InetAddress
import java.time.Duration.ofSeconds

@RestController
class ReactiveWebfluxController : Logging {

  @PostMapping("/hello")
  @ResponseBody
  fun hello(): Mono<String> {
    log.info("Responding Spring Boot Webflux...")
    return Mono.just("Hello from webflux!").delayElement(ofSeconds(10)).log()
  }

  @GetMapping("/hello")
  @ResponseBody
  fun helloGet(): Mono<String> {
    val hostAddress = InetAddress.getLocalHost().hostAddress
    log.info("$hostAddress: Responding Spring Boot Webflux hello GET command...")

    log.trace("$hostAddress: A TRACE Message");
    log.debug("$hostAddress: A DEBUG Message");
    log.info("$hostAddress: An INFO Message");
    log.warn("$hostAddress: A WARN Message");
    log.error("$hostAddress: An ERROR Message");


    return Mono.just("IP address is: $hostAddress").delayElement(ofSeconds(5))
      .doOnNext { log.info("IP address is: $hostAddress") }.log()
  }
}
