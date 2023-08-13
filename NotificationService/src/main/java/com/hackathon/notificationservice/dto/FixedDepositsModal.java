package com.hackathon.notificationservice.dto;

public class FixedDepositsModal {

	private int depositId;

	private int customerId;

	private int depositTenure;

	private double interestRate;

	private double depositAmount;

	private double maturedAmount;

	private double interestAmount;

	private String depositStartDate;

	private String maturityDate;

	private String active;

	private String depositMatured;
	
	
	

	@Override
	public String toString() {
		return "FixedDepositsModal [depositId=" + depositId + ", customerId=" + customerId + ", depositTenure="
				+ depositTenure + ", interestRate=" + interestRate + ", depositAmount=" + depositAmount
				+ ", maturedAmount=" + maturedAmount + ", interestAmount=" + interestAmount + ", depositStartDate="
				+ depositStartDate + ", maturityDate=" + maturityDate + ", active=" + active + ", depositMatured="
				+ depositMatured + "]";
	}

	public int getDepositId() {
		return depositId;
	}

	public void setDepositId(int depositId) {
		this.depositId = depositId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getDepositTenure() {
		return depositTenure;
	}

	public void setDepositTenure(int depositTenure) {
		this.depositTenure = depositTenure;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getDepositAmount() {
		return depositAmount;
	}

	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}

	public double getMaturedAmount() {
		return maturedAmount;
	}

	public void setMaturedAmount(double maturedAmount) {
		this.maturedAmount = maturedAmount;
	}

	public double getInterestAmount() {
		return interestAmount;
	}

	public void setInterestAmount(double interestAmount) {
		this.interestAmount = interestAmount;
	}

	public String getDepositStartDate() {
		return depositStartDate;
	}

	public void setDepositStartDate(String depositStartDate) {
		this.depositStartDate = depositStartDate;
	}

	public String getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(String maturityDate) {
		this.maturityDate = maturityDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getDepositMatured() {
		return depositMatured;
	}

	public void setDepositMatured(String depositMatured) {
		this.depositMatured = depositMatured;
	}

	
	
	
	

	
}
