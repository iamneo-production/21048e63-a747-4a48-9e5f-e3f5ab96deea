package com.hackathon.interestrateservice.serviceImpl;

import com.hackathon.interestrateservice.repository.InterestRateRepo;
import com.hackathon.interestrateservice.service.InterestRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestRateServiceImpl implements InterestRateService {

    @Autowired
    InterestRateRepo interestRateRepo;

    @Override
    public double getInterestRate(int tenure) {
    	return interestRateRepo.getInterestRate(tenure);
    }
}
