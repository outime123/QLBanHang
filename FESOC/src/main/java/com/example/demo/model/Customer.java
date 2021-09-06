package com.example.demo.model;

import lombok.Data;

@Data
public class Customer {
	public int id;
	public String username;
	public String password;
	public String phone;
	public String address;
	public String fname;
	public String lname;
	public String zipcode;
}