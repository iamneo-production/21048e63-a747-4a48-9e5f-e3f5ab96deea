package com.example.CustomerService.Service;

import com.example.CustomerService.Model.Customer;

public interface ICustomerService {

	Customer saveCustomer(Customer customer);

	Customer showcustomer(int customerId);

	Customer deletecustomer(int customerId);

	Customer updatCustomer(int customerId, Customer customer);

}
