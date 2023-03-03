package com.vijay.spring.controller;

import com.vijay.spring.model.Greeting;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@Log4j2
public class GreetingController {

    private static final String template = "Hi, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greet")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        log.info("Handling index route for feature 1....");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}