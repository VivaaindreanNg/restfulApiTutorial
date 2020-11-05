package com.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	public abstract List<Product> findAllByOrderByProductPriceDesc();
	
	public abstract List<Product> findByProductPriceGreaterThan(float price);
}
