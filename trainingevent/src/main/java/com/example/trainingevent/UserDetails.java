package com.example.trainingevent;

import jakarta.validation.constraints.NotBlank;

public class UserDetails {
	
	@NotBlank(message = "Username is required")
	public String userName;
	
	@GmailOnly
	public String email;
	
	@Address
	public String address;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
