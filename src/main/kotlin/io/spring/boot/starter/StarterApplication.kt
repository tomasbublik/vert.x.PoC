package io.spring.boot.starter

import io.common.DELAY_TIME
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.AdviceMode
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.kotlin.coroutine.EnableCoroutine
import org.springframework.kotlin.coroutine.annotation.Coroutine
import org.springframework.kotlin.coroutine.context.DEFAULT_DISPATCHER
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.lang.Thread.sleep

@SpringBootApplication
class StarterApplication

fun main(args: Array<String>) {
  runApplication<StarterApplication>(*args)
}

@Configuration
@EnableCaching
@EnableCoroutine(
  proxyTargetClass = false, mode = AdviceMode.PROXY,
  order = Ordered.LOWEST_PRECEDENCE, schedulerDispatcher = "")
class ConfigClass

@RestController
@Coroutine(DEFAULT_DISPATCHER)
class SimpleController {

  @Autowired
  lateinit var fluxDbService: FluxDbService

  @PostMapping("/")
  fun helloPost(): Flux<String> = fluxDbService.getFluxData()

  @GetMapping("/")
  fun helloGet(): Flux<String> = fluxDbService.getFluxData()

  @PostMapping("/coroutines")
  fun helloPostCoroutines(): String {
    return runBlocking { fluxDbService.getData() }
  }

  @GetMapping("/coroutines")
  fun helloGetCoroutines(): String {
    return runBlocking { fluxDbService.getData() }
  }

  @PostMapping("/mvc_coroutines")
  suspend fun helloPostMVCCoroutines(): String {
    return fluxDbService.getData()
  }

  @GetMapping("/mvc_coroutines")
  suspend fun helloGetMVCCoroutines(): String {
    return fluxDbService.getData()
  }
}

@Service
@Coroutine(DEFAULT_DISPATCHER)
class FluxDbService {

  fun getFluxData(): Flux<String> {
    sleep(DELAY_TIME)
    println("Responding Spring Boot...")
    return Flux.just("Kotlin: Hello Spring Boot Flux!")
  }

  suspend fun getData(): String {
    delay(DELAY_TIME)
    println("Responding Spring Boot Coroutines...")
    return "Kotlin: Hello Spring Boot!"
  }
}
