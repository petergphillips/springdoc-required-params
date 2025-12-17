package com.example.springdocrequiredparameters

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = RANDOM_PORT)
class RequiredParameterTest(
  @param:Autowired val webTestClient: WebTestClient,
) {
  @Test
  fun `parameter should be required`() {
    webTestClient.get().uri("/")
      .exchange()
      .expectStatus()
      .isBadRequest
  }

  @Test
  fun `parameter should be marked as required in api docs`() {
    webTestClient.get().uri("/v3/api-docs")
      .exchange()
      .expectStatus()
      .isOk
      .expectBody()
      .consumeWith(System.out::println)
      .jsonPath("paths./.get.parameters[0].required").isEqualTo("true")
  }
}
