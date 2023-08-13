package com.hackathon.fixeddepositservice.feginclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="INTEREST-RATE-SERVICE")
public interface InterestRate {
	
	@GetMapping("/api/interest-rates/getInterest/{tenure}")
	public double getInterestRate(@PathVariable("tenure") int tenure);
}
