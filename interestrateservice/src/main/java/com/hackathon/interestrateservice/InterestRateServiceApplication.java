package com.hackathon.interestrateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InterestRateServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterestRateServiceApplication.class, args);
	}

}
