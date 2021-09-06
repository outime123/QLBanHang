package com.example.demo.model;



import lombok.Data;


@Data

public class Payment {

	public int id;
	public String method;
	public String customer_id;
}
