package com.example.CustomerService.FeginClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.CustomerService.dto.DepositsRequest;
import com.example.CustomerService.dto.FixedDepositsModal;


@FeignClient(name="FIXED-DEPOSIT-SERVICE")
public interface FixedDepositProxy {
	@PostMapping("/api/fixed-deposits/add")
	public ResponseEntity<FixedDepositsModal> addDepositDetails(@RequestBody DepositsRequest depositsRequest);
}
