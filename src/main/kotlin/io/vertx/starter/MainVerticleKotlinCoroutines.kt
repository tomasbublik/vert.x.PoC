package io.vertx.starter

import io.common.DELAY_TIME
import io.common.PORT
import io.vertx.core.Handler
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServerRequest
import io.vertx.kotlin.core.http.listenAwait
import io.vertx.kotlin.coroutines.CoroutineVerticle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainVerticleKotlinCoroutines : CoroutineVerticle() {

  override fun start(startPromise: Promise<Void>?) {
    launch { startServer() }
  }

  private suspend fun startServer() {
    vertx.createHttpServer()
      .requestHandler(Handler<HttpServerRequest> { this.handleResponse(it) })
      .listenAwait(config.getInteger("http.port", PORT))
  }

  private fun handleResponse(req: HttpServerRequest) {
    launch {
      delay(DELAY_TIME)
      println("Responding from Vert.x Coroutines...")
      req.response().end("Kotlin Coroutine: Hello Vert.x!")
    }
  }
}

fun main() {
  val vertx = Vertx.vertx()
  vertx.deployVerticle(MainVerticleKotlinCoroutines())
}
