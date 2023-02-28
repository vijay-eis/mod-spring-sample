package com.vijay.spring.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @GetMapping("/hw")
    public String HelloWorld(){
        return "Hello World";
    }
}