package com.example.mobileshop.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "phone_details")
public class Phone {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "native")
	private Integer id;
	
	@Column(length = 100)
	private String name;
	
	@Column(length = 255)
	private String description;
	
	@Column(length = 10)
	private Integer price;
	//getters and setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}

}
