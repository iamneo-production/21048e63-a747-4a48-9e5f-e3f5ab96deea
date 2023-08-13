package com.example.CustomerService.dto;


import lombok.Builder;
import lombok.Data;




@Data

@Builder
public class DepositsRequest {

    private int customerId;

    private String depositStartDate;

    private int tenure;

    private double depositAmount;
    
    private double accountBalance;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getDepositStartDate() {
		return depositStartDate;
	}

	public void setDepositStartDate(String depositStartDate) {
		this.depositStartDate = depositStartDate;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public DepositsRequest(int customerId, String depositStartDate, int tenure, double depositAmount,
			double accountBalance) {
		super();
		this.customerId = customerId;
		this.depositStartDate = depositStartDate;
		this.tenure = tenure;
		this.depositAmount = depositAmount;
		this.accountBalance = accountBalance;
	}

	public DepositsRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DepositsRequest [customerId=" + customerId + ", depositStartDate=" + depositStartDate + ", tenure="
				+ tenure + ", depositAmount=" + depositAmount + ", accountBalance=" + accountBalance + "]";
	}
	
	
	

    
}
