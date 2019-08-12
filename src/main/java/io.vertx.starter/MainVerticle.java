package io.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;

import static io.common.ConstKt.DELAY_TIME;
import static io.common.ConstKt.PORT;

public class MainVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }

  @Override
  public void start() {
    vertx.createHttpServer()
      .requestHandler(this::handleResponse)
      .listen(PORT);
  }

  private void handleResponse(final HttpServerRequest req) {
    vertx.setTimer(DELAY_TIME, new Handler<Long>() {
      @Override
      public void handle(Long timerId) {
        req.response().setStatusCode(200);
        req.response().end("Java: Hello Vert.x!");
      }
    });
  }
}
