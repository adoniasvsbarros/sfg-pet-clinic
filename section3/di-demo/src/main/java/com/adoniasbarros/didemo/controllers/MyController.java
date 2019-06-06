package com.adoniasbarros.didemo.controllers;

import org.springframework.stereotype.Controller;

import com.adoniasbarros.didemo.services.GreetingService;

@Controller
public class MyController {
	
	private GreetingService greetingService;
		
	public MyController(GreetingService greetingService) {
		this.greetingService = greetingService;
	}

	public String  hello() {
		System.out.println("Hello!");
		return greetingService.sayGreeting();
	}
}
