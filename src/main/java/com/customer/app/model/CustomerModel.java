package com.customer.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;

@Builder
@Entity(name = "CustomerModel")
@Table(name = "customer")

public class CustomerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cust_id")
	private int cust_id;

	@Column(name = "name")
	private String name;
	@Column(name = "phone")
	private String phone;
	@Column(name = "email")
	private String email;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return cust_id;
	}

	public void setId(int id) {
		this.cust_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CustomerModel(int cust_id, String name, String phone, String email, String username, String password) {
		super();
		this.cust_id = cust_id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public CustomerModel() { // TODO Auto-generated constructor stub

	}
}
