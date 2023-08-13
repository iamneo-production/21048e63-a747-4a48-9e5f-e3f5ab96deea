package com.hackathon.interestrateservice.controller;

import com.hackathon.interestrateservice.serviceImpl.InterestRateServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/interest-rates")
public class InterestRateController {

	@Autowired
	InterestRateServiceImpl interestRateServiceImpl;

	@GetMapping("getInterest/{tenure}")
	public double getInterestRate(@PathVariable("tenure") int tenure) {
		if (StringUtils.isNotBlank(Integer.toString(tenure))) {
			double xx = interestRateServiceImpl.getInterestRate(tenure);
			return xx;
		}
		return 0;

	}
}
