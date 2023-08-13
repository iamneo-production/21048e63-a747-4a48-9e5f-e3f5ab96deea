package com.example.CustomerService.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int customerId;
	@NotBlank
	@Size(min=5,max = 30,message ="First name should have at least 5 characters")
	private String firstName;
	@NotBlank
    @Size(min=5,max = 30,message ="Last name should have at least 5 characters")
	private String lastName;
	@NotBlank
    @Size(min=10,max = 10,message ="Number should contain 10 digits.")
	private	String mobileNumber;
	@NotBlank
    @Email(message = "Enter valid Email.")
	private String userEmail;
	@NotBlank
    @Size(min=8,message ="Password Should have Atleast 8 characters")
	private String password;
	private String status;
	
	
	public Customer(int customerId, String firstName, String lastName, String mobileNumber, String userEmail,
			String password) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.userEmail = userEmail;
		this.password = password;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mobileNumber=" + mobileNumber + ", userEmail=" + userEmail + ", password=" + password + "]";
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}

