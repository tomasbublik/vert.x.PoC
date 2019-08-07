import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("java")
  kotlin("jvm") version "1.3.41"
}

buildscript {
  repositories {
    mavenCentral()
  }

  dependencies {
    classpath(kotlin("gradle-plugin", version = "1.3.41"))
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
  mavenCentral()
}

dependencies {
  implementation("io.vertx:vertx-core:3.8.0")
  implementation("io.vertx:vertx-lang-kotlin:3.8.0")
  implementation(kotlin("stdlib-jdk8"))
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.0-RC")
  implementation("io.vertx:vertx-lang-kotlin-coroutines:3.8.0")
  testCompile("junit:junit:4.12")
  testCompile("io.vertx:vertx-unit:3.7.0")
}

group = "io.vertx.starter"
version = "1.0-SNAPSHOT"
java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
  jvmTarget = "1.8"
}

val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
  jvmTarget = "1.8"
}
