package com.example.CustomerService.Repo;

import com.example.CustomerService.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	//Customer findById(String customerId);
}
