package com.demo.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*; 



@ExtendWith(MockitoExtension.class)
class GreetingImplTest {
	@Mock
	private GreetingService service;
	
	@InjectMocks
	private GreetingImpl greeting;


	@Test
	void greetShoudReturnValidOutput() {
		System.out.println("greetShoudReturnValidOutput");
		String s="junit";
		when(service.greetings(s)).thenReturn("hello:junit");
		
		String result=greeting.greetings(s);
		String expected="hello:junit";
		assertEquals(expected, result);
	}
	
	@Test()
	public void greetShouldThrowException_for_nameIsNull() {
		System.out.println("greetShouldThrowException_for_nameIsNull");
		when(service.greetings(null)).thenThrow(IllegalArgumentException.class);
		assertThrows(IllegalArgumentException.class,()->greeting.greetings(null));
		verify(service).greetings(null);
	}
	
	@Test()
	public void greetShouldThrowException_for_nameIsBlank() {
		System.out.println("greetShouldThrowException_for_nameIsBlank");
		when(service.greetings("")).thenThrow(IllegalArgumentException.class);
		assertThrows(IllegalArgumentException.class, ()->greeting.greetings(""));
	}
	
	@AfterEach
	public void destory() {
		System.out.println("destory");
		greeting=null;
	}

}
