package com.example.demo.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	@Query("SELECT t FROM Product t WHERE type = ?1")
    public Iterable<Product> getAllProductByType(@Param("type") String type);
	@Query("SELECT t FROM Product t WHERE level = 'woman' AND type = ?1")
    public Iterable<Product> getAllProductWomanByType(@Param("type") String type);
	@Query("SELECT t FROM Product t WHERE level = 'man' AND type = ?1")
    public Iterable<Product> getAllProductManByType(@Param("type") String type);
	@Query("SELECT t FROM Product t WHERE level = 'childen' AND type = ?1")
    public Iterable<Product> getAllProductChildenByType(@Param("type") String type);
}