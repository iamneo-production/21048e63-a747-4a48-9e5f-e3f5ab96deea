package com.hackathon.notificationservice.dto;


public class NotificationRequestData {

	private String to;
	private String deposit_amount;
	private String maturity_amount;
	private String maturity_date;
	private String customer_id;
	
	
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDeposit_amount() {
		return deposit_amount;
	}
	public void setDeposit_amount(String deposit_amount) {
		this.deposit_amount = deposit_amount;
	}
	public String getMaturity_amount() {
		return maturity_amount;
	}
	public void setMaturity_amount(String maturity_amount) {
		this.maturity_amount = maturity_amount;
	}
	public String getMaturity_date() {
		return maturity_date;
	}
	public void setMaturity_date(String maturity_date) {
		this.maturity_date = maturity_date;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	
	
}
