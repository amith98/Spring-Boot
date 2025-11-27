package com.example.springurlshortener.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "springurl_urldata")
public class UrlData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Integer userid;
	private String title;
	private String longurl;
	private String shorturl;
	@CreatedDate
	private LocalDateTime createdTime;
	
	//Constructors default and parameterized
	public UrlData() {
		super();
	}
	public UrlData(Integer userid,String title,String longurl) {
		this.userid = userid;
		this.title = title;
		this.longurl = longurl;
	}
	//Getters and Setters
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLongurl() {
		return longurl;
	}
	public void setLongurl(String longurl) {
		this.longurl = longurl;
	}
	public String getShorturl() {
		return shorturl;
	}
	public void setShorturl(String shorturl) {
		this.shorturl = shorturl;
	}
	public LocalDateTime getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime() {
		this.createdTime = LocalDateTime.now();
	}
}
