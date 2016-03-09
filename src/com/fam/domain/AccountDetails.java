package com.fam.domain;

/**
 * Domain object representing a User Account.
 * @author forum
 *
 */
public class AccountDetails {

	private Long accountId;
	private Double currentBalance;
	private String firstName;
	private String lastName;
	private String address;
	private String emailId;
	public Long getAccountId() {
		return accountId;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public Double getCurrentBalance() {
		return currentBalance;
	}
	public void setCurrentBalance(Double currentBalance) {
		this.currentBalance = currentBalance;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	@Override
	public String toString() {
		return "Account Id: "+accountId+
		", Name: " + firstName+ " " + lastName+
		", Current Balance(GBP): " +currentBalance+
		", Email Id: " + emailId+
		", Address " + address;
	}
	
	
}
