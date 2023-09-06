package com.lokesh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringEurekaClientHiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEurekaClientHiServiceApplication.class, args);
	}

}
