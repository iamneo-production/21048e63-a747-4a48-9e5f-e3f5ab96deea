package com.hackathon.interestrateservice.service;

import org.springframework.stereotype.Service;

@Service
public interface InterestRateService {

    double getInterestRate(int tenure);
}
