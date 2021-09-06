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

import com.example.demo.data.ProductRepository;
import com.example.demo.model.Cart;
import com.example.demo.model.Product;


@RestController
@RequestMapping(path = "/product", produces = "application/json")
@CrossOrigin(origins = "*")
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
//	@Autowired
//	EntityLinks entityLinks;

	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@GetMapping
	public Iterable<Product> getAllOrder(){
		return productRepository.findAll();
	}
	
	@GetMapping("/{ID}")
	public Product productById(@PathVariable("ID") int ID) {
		Optional<Product> option = productRepository.findById(ID);
		if(option.isPresent()) {
			return option.get();
		}
		return null;
	}
	@GetMapping("/type/{type}")
    public Iterable<Product> getAllProductByType(@PathVariable("type") String type){
        return productRepository.getAllProductByType(type);
    }
	
	@GetMapping("/woman/{woman}")
    public Iterable<Product> getAllProductWomanByType(@PathVariable("woman") String woman){
        return productRepository.getAllProductWomanByType(woman);
    }
	@GetMapping("/man/{man}")
    public Iterable<Product> getAllProductManByType(@PathVariable("man") String man){
        return productRepository.getAllProductManByType(man);
    }
	@GetMapping("/childen/{childen}")
    public Iterable<Product> getAllProductChildenByType(@PathVariable("childen") String childen){
        return productRepository.getAllProductChildenByType(childen);
    }
//	
//	@PostMapping
//	@ResponseStatus(HttpStatus.CREATED)
//	public Order postCustomer(@RequestBody Order order) {
//		return orderRepository.save(order);
//	}
}
