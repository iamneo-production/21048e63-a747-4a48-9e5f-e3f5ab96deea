package com.example.CustomerService.FeginClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name="AccountController")
public interface AccountProxy {

	@PostMapping("/api/accounts")
	public AccountProxy addAccount();
}
