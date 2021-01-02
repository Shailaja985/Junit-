package com.demo.junit;

public class GreetingImpl implements Greetings {
	
	private GreetingService service;
	
	public String greetings(String name) {
		
		return service.greetings(name);
	}

}
