package com.example.bookinventory.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "shop_details")
public class Shop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String description;
	private String category;
	private Float price;
	private String expiryDate;
	private Integer stock;
	
	//Getters and Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public  String getName() {
		return  name;
	}
	public void setName(String  name) {
		this. name =  name;
	}
	public  String getDescription() {
		return  description;
	}
	public void setDescription(String  description) {
		this. description =  description;
	}
	public  String getCategory() {
		return  category;
	}
	public void setCategory(String  category) {
		this. category =  category;
	}
	public  Float getPrice() {
		return  price;
	}
	public void setPrice(Float  price) {
		this. price =  price;
	}
	public  String getExpiryDate() {
		return  expiryDate;
	}
	public void setExpiryDate(String  expiryDate) {
		this. expiryDate =  expiryDate;
	}
	public  Integer getStock() {
		return  stock;
	}
	public void setStock(Integer  stock) {
		this. stock =  stock;
	}
	

}
