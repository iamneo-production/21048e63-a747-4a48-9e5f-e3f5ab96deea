package com.example.CustomerService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CustomerService.FeginClient.AccountProxy;
import com.example.CustomerService.FeginClient.FixedDepositProxy;
import com.example.CustomerService.FeginClient.NotificationServiceProxy;
import com.example.CustomerService.Model.Customer;
import com.example.CustomerService.Service.CustomerServiceImpl;
import com.example.CustomerService.dto.DepositsRequest;
import com.example.CustomerService.dto.FixedDepositsModal;
import com.example.CustomerService.dto.NotificationRequestData;



@RestController
@RequestMapping("/api/customer")

public class CustomerController {
	
	@Autowired
	private CustomerServiceImpl customeService;
	
	@Autowired
	private AccountProxy account;
	
	@Autowired
	private FixedDepositProxy fixeddeposit;
	
	@Autowired
	private NotificationServiceProxy notificationServiceProxy;
	
	//URL : http://localhost:8086/api/customer/addCustomer
	@PostMapping("/addCustomer")
	public Customer saveCustomer(@RequestBody Customer customer)
	{
		
		Customer customer1 = customeService.saveCustomer(customer);
		return customer1;
	}
	
	//URL : http://localhost:8086/api/customer/updateCustomer/452
	@PutMapping("/updateCustomer/{customerId}")
	public Customer updateCustomer(@PathVariable int customerId,@RequestBody Customer customer)
	{
		
		Customer customer1 = customeService.updatCustomer(customerId, customer);
		return customer1;
	}
	
	
	//URL : http://localhost:8086/api/customer/getcustomer/452
	@GetMapping("/getcustomer/{customerId}")
	public Customer getcustomer(@PathVariable int customerId)
	{
		Customer customer1 = customeService.showcustomer(customerId);
		return customer1;
	}
	
	//URL : http://localhost:8086/api/customer/deleteCustomer/452
	@DeleteMapping("/deleteCustomer/{customerId}")
	public Customer deletecustomer(@PathVariable int customerId)
	{
		Customer customer1 = customeService.deletecustomer(customerId);
		return customer1;
	}
	
	@PostMapping("/addAccount")
	public AccountProxy addAccount()
	{
		AccountProxy a = account.addAccount();
		return a;
	}

	@PostMapping("/addfixeddeposit")
	public ResponseEntity<String> addDepositDetails(@RequestBody DepositsRequest depositsRequest)
	{
		FixedDepositsModal fixedDepositsModal = null;
		ResponseEntity<FixedDepositsModal> responseEntity =   fixeddeposit.addDepositDetails(depositsRequest);
		
		try
		{
			fixedDepositsModal = responseEntity.getBody();
			
		}
		catch(Exception e)
		{
			System.out.println("insdieerror");
			System.out.println("no body"+e);
		}
		
		if(responseEntity.getStatusCodeValue()==201)
		{
			
			Customer customer = getcustomer(fixedDepositsModal.getCustomerId());
			NotificationRequestData notificationRequestData = new NotificationRequestData(customer.getUserEmail(),Double.toString(fixedDepositsModal.getDepositAmount()),Double.toString(fixedDepositsModal.getMaturedAmount()),fixedDepositsModal.getMaturityDate(),Integer.toString(fixedDepositsModal.getCustomerId()));

			ResponseEntity<Object> re  = notificationServiceProxy.sendNotification(notificationRequestData);
			System.out.println(re.getBody());
			
			return new ResponseEntity<String>("FD Created.", HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("FD Creation Failed.", HttpStatus.BAD_REQUEST);
	}
		
}
