package com.example.tasks_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tasks_api.dto.HelloResponse;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Bonjour depuis Spring Boot !";
    }

    @GetMapping("/hello-json")
    public HelloResponse sayHelloJson() {
        return new HelloResponse("Bonjour en JSON depuis Spring Boot !");
    }
}
