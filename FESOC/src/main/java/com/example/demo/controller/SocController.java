package com.example.demo.controller;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Customer;


@Controller
@RequestMapping("/soc")
public class SocController {
	private String ngrokHost ;
	private RestTemplate rest= new RestTemplate();

	@GetMapping("/home")
	public String home(Model model) {
		
		return "/home";
	}
	@GetMapping("/login")
	public String login(Model model) {
		
		return "/login";
	}
	@GetMapping("/Ao")
	public String ao(Model model) {
		
		return "/Ao";
	}
	@GetMapping("/Quan")
	public String quan(Model model) {
		
		return "/Quan";
	}
	@GetMapping("/Pay")
	public String pay(Model model) {
		
		return "/Pay";
	}
	@GetMapping("/register")
	public String register(Model model) {
		
		return "/register";
	}
	@GetMapping("/Timkiem")
	public String timkiem(Model model) {
		
		return "/Timkiem";
	}
	@GetMapping("/wishlist")
	public String wishlist(Model model) {
		
		return "/wishlist";
	}
	

}