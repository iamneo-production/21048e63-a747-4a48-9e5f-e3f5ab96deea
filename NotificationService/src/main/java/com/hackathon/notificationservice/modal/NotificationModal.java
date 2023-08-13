package com.hackathon.notificationservice.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class NotificationModal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String customer_name;
	private String fd_account_number;
	private String deposite_start_date;
	private String deposit_amount;
	private String maturity_amount;
	private String maturity_date;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomer_name() {
		return customer_name;
	}
	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}
	public String getFd_account_number() {
		return fd_account_number;
	}
	public void setFd_account_number(String fd_account_number) {
		this.fd_account_number = fd_account_number;
	}
	public String getDeposite_start_date() {
		return deposite_start_date;
	}
	public void setDeposite_start_date(String deposite_start_date) {
		this.deposite_start_date = deposite_start_date;
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
	
	

}
