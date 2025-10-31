package com.example.bookinventory.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "book_details")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String title;
	private String author;
	private String genre;
	private Float price;
	private String publishedDate;
	
	//Getters and Setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public  String getTitle() {
		return  title;
	}
	public void setTitle(String  title) {
		this. title =  title;
	}
	public  String getAuthor() {
		return  author;
	}
	public void setAuthor(String  author) {
		this. author =  author;
	}
	public  String getGenre() {
		return  genre;
	}
	public void setGenre(String  genre) {
		this. genre =  genre;
	}
	public  Float getPrice() {
		return  price;
	}
	public void setPrice(Float  price) {
		this. price =  price;
	}
	public  String getPublishedDate() {
		return  publishedDate;
	}
	public void setPublishedDate(String  publishedDate) {
		this. publishedDate =  publishedDate;
	}
	

}
