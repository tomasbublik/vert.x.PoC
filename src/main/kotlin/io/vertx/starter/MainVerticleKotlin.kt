package io.vertx.starter

import io.common.DELAY_TIME
import io.common.PORT
import io.vertx.core.AbstractVerticle
import io.vertx.core.Handler
import io.vertx.core.Vertx
import io.vertx.core.http.HttpServerRequest

class MainVerticleKotlin : AbstractVerticle() {

  override fun start() {
    vertx.createHttpServer()
      .requestHandler(Handler<HttpServerRequest> { this.handleResponse(it) })
      .listen(PORT)
  }

  private fun handleResponse(req: HttpServerRequest) {
    vertx.setTimer(DELAY_TIME) {
      println("Responding from Vert.x...")
      req.response().statusCode = 200
      req.response().end("Kotlin: Hello Vert.x!")
    }
  }
}

fun main() {
  val vertx = Vertx.vertx()
  vertx.deployVerticle(MainVerticleKotlin())
}
