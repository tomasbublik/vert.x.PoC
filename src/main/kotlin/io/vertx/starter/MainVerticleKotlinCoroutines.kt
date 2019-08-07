package io.vertx.starter

import io.vertx.core.Handler
import io.vertx.core.Promise
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServerRequest
import io.vertx.kotlin.core.http.listenAwait
import io.vertx.kotlin.coroutines.CoroutineVerticle
import kotlinx.coroutines.launch

class MainVerticleKotlinCoroutines : CoroutineVerticle() {

  override fun start(startPromise: Promise<Void>?) {
    launch { startServer() }
  }

  private suspend fun startServer() {
    vertx.createHttpServer()
      .requestHandler(Handler<HttpServerRequest> { this.handleResponse(it) })
      .listenAwait(config.getInteger("http.port", 8080))
  }

  override fun stop(stopPromise: Promise<Void>?) {
    super.stop(stopPromise)
  }

  private fun handleResponse(req: HttpServerRequest) {
    launch {
      // println("Kotlin Coroutine: Response received")
      req.response().end("Kotlin Coroutine: Hello Vert.x!")
    }
  }
}

fun main() {
  val vertx = Vertx.vertx()
  vertx.deployVerticle(MainVerticleKotlinCoroutines())
}
