@echo off

SET LAUNCHER="io.vertx.core.Launcher"
SET VERTICLE="io.vertx.starter.MainVerticle"
SET CMD="mvnw compile"
SET VERTX_CMD="run"
SET CMD_LINE_ARGS=%*

call mvnw compile dependency:copy-dependencies

java -cp  "target\dependency\*;target\classes" %LAUNCHER% %VERTX_CMD% %VERTICLE% --redeploy="src\main\**\*" --on-redeploy=%CMD% --launcher-class=%LAUNCHER% %CMD_LINE_ARGS%
