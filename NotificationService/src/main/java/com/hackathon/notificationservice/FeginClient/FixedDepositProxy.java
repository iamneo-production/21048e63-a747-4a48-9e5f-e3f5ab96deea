package com.hackathon.notificationservice.FeginClient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.hackathon.notificationservice.dto.FixedDepositsModal;



@FeignClient(name="FIXED-DEPOSIT-SERVICE")
public interface FixedDepositProxy {
	
	@PostMapping("/api/fixed-deposits/getFixedDepositsByMaturityDate")
	public List<FixedDepositsModal> getFixedDepositsByMaturityDate(@RequestBody String maturityDate);

}
