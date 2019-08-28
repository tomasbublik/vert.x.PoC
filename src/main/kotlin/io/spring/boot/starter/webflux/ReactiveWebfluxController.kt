package io.spring.boot.starter.webflux

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.Duration.ofSeconds

@RestController
class ReactiveWebfluxController {

  @PostMapping("/hello")
  @ResponseBody
  fun hello(): Mono<String> {
    println("Responding Spring Boot Webflux...")
    return Mono.just("Hello from webflux!").delayElement(ofSeconds(10)).log()
  }

  @GetMapping("/hello")
  @ResponseBody
  fun helloGet(): Mono<String> {
    println("Responding Spring Boot Webflux...")
    return Mono.just("Hello from webflux!").delayElement(ofSeconds(10)).log()
  }
}
