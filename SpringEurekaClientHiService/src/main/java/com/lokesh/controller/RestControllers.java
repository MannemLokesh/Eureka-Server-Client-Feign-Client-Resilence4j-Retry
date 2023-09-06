package com.lokesh.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lokesh.helloserviceclient.HelloClient;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class RestControllers 
{
	@Autowired
	private HelloClient client;
	
	private static final Logger log = LoggerFactory.getLogger(RestControllers.class);
	@CrossOrigin(origins = {"*"})
	@GetMapping("/hi/{name}")
//	@CircuitBreaker(name = "sayHello", fallbackMethod = "fallBackHello")
	@Retry(name="sayHello", fallbackMethod = "fallBackHello")
	public ResponseEntity<?> sayHello(@PathVariable String name)
	{
		System.out.println("in hi service");
		ResponseEntity<String> sayHello = client.sayHello(name);
//		System.out.println(client.sayHello(name));
//		System.out.println(sayHello);
		String body = sayHello.getBody();
		int i=1/0;
		System.out.println("working");
		return new ResponseEntity<String>("Hi Service "+ name+ body, HttpStatus.OK);
	}
	
	//To write fallBackMethod, we have to follow some rules
	//1. Method should accept the parameter which the circuit breaker (sayHello) is having
	//2. fallBackMethod should also have to accept one more parameter called Throwable throwable
	//3. fallBackMethod should return the same as circuit breaker (sayHello) is returning.
	private ResponseEntity<?> fallBackHello(String name, Throwable throwable)
	{
		return new ResponseEntity<String>("Hi .....", HttpStatus.OK);
	}
}
