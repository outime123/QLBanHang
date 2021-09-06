package com.example.demo.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.example.demo.model.Payment;

public interface PaymentRepository extends CrudRepository<Payment, Integer>{
	@Query(value = "SELECT t FROM Payment t WHERE customer_id = ?1" )
    public Payment getPaymentByCustomerId(@Param("customer_id") int customer_id);
}
