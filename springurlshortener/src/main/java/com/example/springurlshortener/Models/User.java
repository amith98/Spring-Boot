package com.example.springurlshortener.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


@Entity
@Table(name = "springurl_users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userid;
	@Column(unique = true, nullable = false)
	private String email;
	private String password;
	
	//Constructors default and parameterized
	public User() {
		super();
	}
	
	public User(String email,String password) {
		this.email = email;
		this.password = password;
	}
	
	//Getters and Setters
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
