package com.example.herokudemo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	String name;
	
	Long mobile;
	
	String message;
	
	String email;

	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(String name, Long mobile, String message, String email) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.message = message;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", name=" + name + ", mobile=" + mobile + ", message=" + message + ", email="
				+ email + "]";
	}
	
	
}
