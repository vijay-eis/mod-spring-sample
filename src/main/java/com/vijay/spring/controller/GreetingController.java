package com.vijay.spring.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.vijay.spring.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hi, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greet")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}