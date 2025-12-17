package com.example.springdocrequiredparameters

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class RequiredController {
  @GetMapping("/")
  fun greet(greeting: Greeting): String = greeting.name
}

data class Greeting(val name: String)
