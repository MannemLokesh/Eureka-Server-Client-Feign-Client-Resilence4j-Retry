package com.lokesh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllers 
{
	@Autowired
	private Environment environment;
	
	@GetMapping("/hello/{name}")
	public ResponseEntity<?> sayHello(@PathVariable String name)
	{
		System.out.println(environment.getProperty("server.port"));
		System.out.println(environment.getProperty("local.server.port"));
//		return ResponseEntity.ok(null);
		return new ResponseEntity<String>("Hello Service"+ name, HttpStatus.OK);
	}
}
