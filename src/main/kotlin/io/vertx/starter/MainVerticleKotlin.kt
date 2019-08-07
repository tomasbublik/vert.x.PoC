package io.vertx.starter

import io.vertx.core.AbstractVerticle
import io.vertx.core.Handler
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServerRequest

class MainVerticleKotlin : AbstractVerticle() {

  override fun start() {
    vertx.createHttpServer()
      .requestHandler(Handler<HttpServerRequest> { this.handleResponse(it) })
      .listen(8080)
  }

  private fun handleResponse(req: HttpServerRequest) {
    // println("Kotlin: Response received")
    req.response().end("Kotlin: Hello Vert.x!")
  }
}

fun main() {
  val vertx = Vertx.vertx()
  vertx.deployVerticle(MainVerticleKotlin())
}
