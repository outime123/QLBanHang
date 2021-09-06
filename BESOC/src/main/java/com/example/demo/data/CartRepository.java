package com.example.demo.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Cart;

public interface CartRepository extends CrudRepository<Cart, Integer>{
	@Query("SELECT t FROM Cart t WHERE customer_id = ?1")
    public Iterable<Cart> getAllCartByCustomerId(@Param("customer_id") int customer_id);
}
