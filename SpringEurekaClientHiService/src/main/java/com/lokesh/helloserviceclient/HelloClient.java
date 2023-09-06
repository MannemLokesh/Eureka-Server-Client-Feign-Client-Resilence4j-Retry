package com.lokesh.helloserviceclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "Hello-Service")
public interface HelloClient 
{
	@GetMapping("/hello/{name}")
	public ResponseEntity<String> sayHello(@PathVariable String name);
}
