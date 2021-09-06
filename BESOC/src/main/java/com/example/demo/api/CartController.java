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

import com.example.demo.data.CartRepository;
import com.example.demo.model.Cart;


@RestController
@RequestMapping(path = "/cart", produces = "application/json")
@CrossOrigin(origins = "*")
public class CartController {
	@Autowired
	private CartRepository cartRepository;
	
//	@Autowired
//	EntityLinks entityLinks;

	public CartController(CartRepository cartdetailRepository) {
		this.cartRepository = cartdetailRepository;
	}
	
	@GetMapping
	public Iterable<Cart> getAllOrder(){
		return cartRepository.findAll();
	}
	
	@GetMapping("/{ID}")
	public Cart cartById(@PathVariable("ID") int ID) {
		Optional<Cart> option = cartRepository.findById(ID);
		if(option.isPresent()) {
			return option.get();
		}
		return null;
	}
	@GetMapping("/customer/{customer}")
    public Iterable<Cart> getAllCartByCustomerId(@PathVariable("customer") int customer){
        return cartRepository.getAllCartByCustomerId(customer);
    }
	@DeleteMapping("/delete/{id}")
    public void deleteCart(@PathVariable("id") int cartid) {
        cartRepository.deleteById(cartid);
    }

}
