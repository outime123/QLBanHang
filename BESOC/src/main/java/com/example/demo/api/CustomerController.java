package com.example.demo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.CustomerRepository;
import com.example.demo.model.Customer;


@RestController
@RequestMapping(path = "/customer", produces = "application/json")
@CrossOrigin(origins = "*")
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
//	@Autowired
//	EntityLinks entityLinks;

	public CustomerController(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@GetMapping
	public Iterable<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	
	@GetMapping("/{ID}")
	public Customer customerById(@PathVariable("ID") int ID) {
		Optional<Customer> option = customerRepository.findById(ID);
		if(option.isPresent()) {
			return option.get();
		}
		return null;
	}
	@GetMapping("/username/{username}")
    public Customer customerByEmail(@PathVariable("username") String username) {
        return customerRepository.getCustomerByUsername(username);
    }
//	@GetMapping("/check/{check}")
//    public boolean checkUsername(@PathVariable("username") String username,@PathVariable("password") String password) {
//		//boolean check = customerRepository.checkUsername(username, password);
//		
//        return check;
//    }
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer postCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
}
