FROM openjdk:11-slim
MAINTAINER Tomáš Bublík<tomas.bublik@gmail.com>
VOLUME /tmp
ARG JAR_FILE=build/libs/*.jar
COPY ./run.sh /
COPY ${JAR_FILE} app.jar
#ARG MAIN_CLASS=io.spring.boot.starter.StarterApplicationKt
#RUN echo "Building image for the main class: $MAIN_CLASS"
ENTRYPOINT ["/run.sh"]
