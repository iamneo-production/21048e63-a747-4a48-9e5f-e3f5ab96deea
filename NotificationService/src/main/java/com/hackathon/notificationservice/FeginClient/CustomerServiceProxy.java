package com.hackathon.notificationservice.FeginClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.hackathon.notificationservice.dto.Customer;



@FeignClient(name="CUSTOMER-SERICE")
public interface CustomerServiceProxy {
	@GetMapping("/api/customer/getcustomer/{customerId}")
	public Customer getcustomer(@PathVariable int customerId);

}
