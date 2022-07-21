package com.example.amigospring.controllers

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {

    @GetMapping
    fun hello() = "Hello Spring World"

    @GetMapping("/list")
    fun list() = listOf("Hello", "World", "Peter")

}