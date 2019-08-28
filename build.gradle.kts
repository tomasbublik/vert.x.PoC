import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("java")
  kotlin("jvm") version "1.3.41"
  kotlin("plugin.spring") version "1.3.41"
  id("org.springframework.boot") version "2.1.7.RELEASE"
  id("io.spring.dependency-management") version "1.0.7.RELEASE"
  id("org.jetbrains.kotlin.plugin.allopen") version "1.3.41"
}

buildscript {
  repositories {
    mavenCentral()
  }

  dependencies {
    classpath(kotlin("gradle-plugin", version = "1.3.41"))
    classpath("org.jetbrains.kotlin:kotlin-allopen:1.3.41")
  }
}

repositories {
  mavenLocal()
  maven {
    url = uri("http://repo.maven.apache.org/maven2")
  }

  maven {
    url = uri("https://aevi.jfrog.io/aevi/libs-release")
  }

  maven {
    url = uri("https://aevi.jfrog.io/aevi/libs-snapshot")
  }
  maven {
    url = uri("https://dl.bintray.com/konrad-kaminski/maven")
  }
  mavenCentral()
}

dependencies {
  implementation("io.vertx:vertx-core:3.8.0")
  implementation("io.vertx:vertx-lang-kotlin:3.8.0")
  implementation(kotlin("stdlib-jdk8"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0-RC")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.3.0-RC")
  implementation("io.vertx:vertx-lang-kotlin-coroutines:3.8.0")
  implementation("org.springframework.boot:spring-boot-starter")
  implementation("org.jetbrains.kotlin:kotlin-reflect")
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  // non-tomcat version => Netty
  //implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-webflux")
  implementation("org.springframework.kotlin:spring-kotlin-coroutine:0.3.7")
  implementation("org.springframework.kotlin:spring-webmvc-kotlin-coroutine:0.3.7")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("junit:junit:4.12")
  testImplementation("io.vertx:vertx-unit:3.7.0")
}

group = "io.vertx.starter"
version = "1.0-SNAPSHOT"
java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
  freeCompilerArgs = listOf("-Xjsr305=strict")
  jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
  freeCompilerArgs = listOf("-Xjsr305=strict")
  jvmTarget = "1.8"
}
