package com.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webapp.model.Product;
import com.webapp.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepo;
	
	//Retrieve
	public List<Product> getAllProduct() {
		return productRepo.findAll();
	}
	
	//Create
	public Product addProduct(Product payload) {
		return productRepo.save(payload);
	}
	
	//Retrieve (specific product)
	public Product getProductById(Integer productId) {
		return productRepo.findById(productId).get();
	}
	
	
	//Delete product based on ID
	public Product deleteProduct(Integer productId) {
		Product deletedProduct = productRepo.findById(productId).get();
		productRepo.deleteById(productId);
		return deletedProduct;
	}
	
	//Update product based on ID
	public Product updateProduct(
			Integer productId,
			String productName,
			float productPrice) {
		
		Product updatedProduct = productRepo.findById(productId).get();
		updatedProduct.setProductName(productName);
		updatedProduct.setProductPrice(productPrice);
		productRepo.save(updatedProduct);
		return updatedProduct;
	}
	
	
	public List<Product> listProductsByDescPrice() {
		return productRepo.findAllByOrderByProductPriceDesc();
	}
	
		
	public List<Product> listProductsPriceMoreThan(float price) {
		return productRepo.findByProductPriceGreaterThan(price);
	}
}
