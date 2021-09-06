package com.example.demo.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.PaymentRepository;
import com.example.demo.model.Customer;
import com.example.demo.model.Payment;


@RestController
@RequestMapping(path = "/payment", produces = "application/json")
@CrossOrigin(origins = "*")
public class PaymentController {
	@Autowired
	private PaymentRepository paymentRepository;
	
//	@Autowired
//	EntityLinks entityLinks;

	public PaymentController(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}
	
	@GetMapping
	public Iterable<Payment> getAllOrder(){
		return paymentRepository.findAll();
	}
	
	@GetMapping("/{ID}")
	public Payment paymentById(@PathVariable("ID") int ID) {
		Optional<Payment> option = paymentRepository.findById(ID);
		if(option.isPresent()) {
			return option.get();
		}
		return null;
	}
	@DeleteMapping("/delete/{id}")
    public void deletePayment(@PathVariable("id") int paymentid) {
        paymentRepository.deleteById(paymentid);
    }
	@GetMapping("/customer/{customer}")
    public Payment customerByEmail(@PathVariable("customer") int customer_id) {
        return paymentRepository.getPaymentByCustomerId(customer_id);
    }
//	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public Order postCustomer(@RequestBody Order order) {
//		return orderRepository.save(order);
//	}
}
