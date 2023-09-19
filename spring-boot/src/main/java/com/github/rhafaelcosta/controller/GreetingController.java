package com.github.rhafaelcosta.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.rhafaelcosta.model.Greeting;

@RestController
public class GreetingController {

	private final AtomicLong counter = new AtomicLong();
	private static final String template = "Hello, %s!";

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(name = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name) );
	}

}
