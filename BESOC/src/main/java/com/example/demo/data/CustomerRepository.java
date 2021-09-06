package com.example.demo.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{
	@Query(value = "SELECT t FROM Customer t WHERE username = ?1" )
    public Customer getCustomerByUsername(@Param("username") String username);
	@Query(value = "SELECT t FROM Customer t WHERE username = ?1 AND passwrod = ?2" )
    public Customer checkUsername(@Param("username") String username,@Param("password") String password);

}
