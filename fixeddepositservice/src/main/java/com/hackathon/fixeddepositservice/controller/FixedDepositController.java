package com.hackathon.fixeddepositservice.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.fixeddepositservice.feginclient.NotificationServiceProxy;
import com.hackathon.fixeddepositservice.modal.DepositsRequest;
import com.hackathon.fixeddepositservice.modal.FixedDepositsModal;
import com.hackathon.fixeddepositservice.repository.FixedDepositsRepo;
import com.hackathon.fixeddepositservice.serviceImpl.FixedDepositServiceImpl;


@RestController
@RequestMapping("/api/fixed-deposits")
public class FixedDepositController {
    
	@Autowired
    FixedDepositServiceImpl fixedDepositServiceImpl;
	
	@Autowired
	FixedDepositsRepo fixedDepositsRepo;
	
	@Autowired
	NotificationServiceProxy notificationServiceProxy;
	
    @PostMapping("/add")
    public ResponseEntity<FixedDepositsModal> addDepositDetails(@RequestBody DepositsRequest depositsRequest){
    	
    	if(depositsRequest.getDepositAmount()<=depositsRequest.getAccountBalance())
    	{	
	        FixedDepositsModal fixedDepositsModal = fixedDepositServiceImpl.addDepositDetails(depositsRequest);
	        //sendMaturityReminders();
	        return new ResponseEntity<>(fixedDepositsModal, HttpStatus.CREATED);
    	}
    	else
    	{
    		System.out.println("the deposit amount is greater than the account balance");
    		return new ResponseEntity<FixedDepositsModal>(HttpStatus.BAD_REQUEST);
    	}
    }
    
    @Scheduled(cron = "0 0 10 * * *")
    public void sendMaturityReminders() {
    	DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedLocalDate = dateTimeFormatter.format(LocalDate.now());
        notificationServiceProxy.sendReminder(formattedLocalDate);
        
    }
    
    @PostMapping("/getFixedDepositsByMaturityDate")
    public List<FixedDepositsModal> getFixedDepositsByMaturityDate(@RequestBody String maturityDate)
    {
    	List<FixedDepositsModal>  fixedDeposits = fixedDepositsRepo.findByMaturityDate(maturityDate);
    	return fixedDeposits;
    }
    
    
    
    
    
    
    
    
    
    
    /* @PostMapping("/calculatematureamount")
    public void calculateMatureAmount(){

    }

    @GetMapping("/alldeposits/{customerId}")
    public ResponseEntity<List<FixedDepositsModal>> allocatedFixedDeposits(@PathVariable("customerId") String customerId){
        List<FixedDepositsModal>  depositsData = fixedDepositServiceImpl.getAllFixedDeposits(customerId, null);
        return new ResponseEntity<>(depositsData, HttpStatus.OK);
    }

    @GetMapping("/alldeposits")
    public ResponseEntity<List<FixedDepositsModal>> getAllFixedDeposits(){
        List<FixedDepositsModal>  depositsData = fixedDepositServiceImpl.getAllFixedDeposits(null, null);
        return new ResponseEntity<>(depositsData, HttpStatus.OK);
    }

    @GetMapping("/deposit/{customerId}/{depositId}")
    public ResponseEntity<List<FixedDepositsModal>> getFixedDepositData(@PathVariable("customerId") String customerId, @PathVariable("depositId") String depositId){
        List<FixedDepositsModal>  depositsData = fixedDepositServiceImpl.getAllFixedDeposits(customerId, depositId);
        return new ResponseEntity<>(depositsData, HttpStatus.OK);
    }

    @PostMapping("/updatedeposit/{customerId}/{depositId}")
    public void updateDepositData(){

    }

    @PostMapping("/deallocatedeposit/{customerId}/{depositId}")
    public void deallocateDeposit(){

    }*/

}
