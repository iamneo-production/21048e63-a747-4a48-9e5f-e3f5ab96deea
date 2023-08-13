package com.example.CustomerService.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CustomerService.Model.Customer;
import com.example.CustomerService.Repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements ICustomerService {
	
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Customer saveCustomer(Customer customer) {
		customer.setStatus("Active");
		Customer customer1 = customerRepo.save(customer);
		
		return customer1;
	}

	@Override
	public Customer showcustomer(int customerId) {
		Customer customer1 = customerRepo.findById(customerId).get();
		return customer1;
	}

	@Override
	public Customer deletecustomer(int customerId) {
		Customer customer1 = customerRepo.findById(customerId).get();
		customer1.setStatus("Inactive");
		customerRepo.save(customer1);
		return customer1;
	}

	@Override
	public Customer updatCustomer(int customerId, Customer customer) {
		customer.setCustomerId(customerId);
		customer.setStatus("Active");
		Customer customer1 = customerRepo.save(customer);
		return customer1;
	}

	
	

}
