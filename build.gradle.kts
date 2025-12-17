plugins {
  id("org.springframework.boot") version "3.5.8"
  id("io.spring.dependency-management") version "1.1.7"
  kotlin("jvm") version "2.2.21"
  kotlin("plugin.spring") version "2.2.21"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
  sourceCompatibility = JavaVersion.VERSION_24
  targetCompatibility = JavaVersion.VERSION_24
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
  implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.14")
  testImplementation("org.springframework.boot:spring-boot-starter-test")
  testImplementation("org.springframework.boot:spring-boot-test-autoconfigure")
  testImplementation("org.springframework.boot:spring-boot-starter-webflux")
}

tasks {
  withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    compilerOptions.jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_24
  }
}

tasks.withType<Test> {
  useJUnitPlatform()
}
