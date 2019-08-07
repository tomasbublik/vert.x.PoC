package io.vertx.starter;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerRequest;

public class MainVerticle extends AbstractVerticle {

  public static void main(String[] args) {
    Vertx vertx = Vertx.vertx();
    vertx.deployVerticle(new MainVerticle());
  }

  @Override
  public void start() {
    vertx.createHttpServer()
      .requestHandler(this::handleResponse)
      .listen(8080);
  }

  private void handleResponse(HttpServerRequest req) {
    // System.out.println("Java: Response received");
    req.response().end("Java: Hello Vert.x!");
  }
}
