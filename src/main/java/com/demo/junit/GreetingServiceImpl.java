package com.demo.junit;

public class GreetingServiceImpl implements GreetingService {

	@Override
	public String greetings(String name) {
		if(name==null || name.length()==0) {
			throw new IllegalArgumentException();
		}
		
		return "hello:"+name;
	}

}
