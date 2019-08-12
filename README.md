Vert.x Gradle Starter Project

== Prerequisites

* JDK 8+

== Running the project

Once you have retrieved the project, you can check that everything works with:

[source]
----
./gradlew build
----

[source]
```shell script
./gradlew build ; docker build -t spring-boot-starter . ; docker run -it --rm -p 80:8080 --name spring-boot-starter -t spring-boot-starter <main_class>

```
Where <main_class> is the name of the class to be started:
```java
io.vertx.starter.MainVerticleKotlinCoroutinesKt
```
to run the Coroutines version of Vert.X

```java
io.vertx.starter.MainVerticleKotlinKt
```
to run the default Vert.X endpoint which similar to the previous ine expects the URL "/"

```java
io.spring.boot.starter.StarterApplication
```
to run the Spring Boot project and enter the URL of "/" to get the general Spring Boot response, or "/coroutines" to get the Coroutines version, or "/mvc_coroutines" to get the resopnse from the Spring Boot MVC Coroutines facility.  
