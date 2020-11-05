package com.webapp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webapp.model.Product;
import com.webapp.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productServe;
	
	private final String ENDPOINT_LIST_ALL = "/product";
	private final String ENDPOINT_INSERT = "/product";
	private final String ENDPOINT_GET_BY_ID = "/product/{id}";
	private final String ENDPOINT_DELETE_BY_ID = "/delete/{id}";
	private final String ENDPOINT_UPDATE_BY_ID = "/update/{id}";
	
	@GetMapping(ENDPOINT_LIST_ALL)
	public List<Product> retrieveAll() {
		return productServe.getAllProduct();
	}
	
	@PostMapping(ENDPOINT_INSERT)
	public Product create(@RequestBody Product payload) {
		return productServe.addProduct(payload);
	}
	
	@GetMapping(ENDPOINT_GET_BY_ID)
	public Product retrieveOne(@PathVariable Integer id) {
		return productServe.getProductById(id);
	}
	
	@DeleteMapping(ENDPOINT_DELETE_BY_ID)
	public Product delete(@PathVariable Integer id) {
		return productServe.deleteProduct(id);
	}
	
	@PutMapping(ENDPOINT_UPDATE_BY_ID)
	public Product update(
			@PathVariable Integer id,
			@RequestParam(value="name", required=false) String name, 
			@RequestParam(value="price", required=false) float price) {
		
		Product product = productServe.updateProduct(id, name, price);
		return product;
	}
	
	
	@GetMapping("/productsByPriceDesc")
	public List<Product> getProductsByPriceDesc() {
		return productServe.listProductsByDescPrice();
	}
	
	
	@GetMapping("/productsMoreThan/{price}")
	public List<Product> test(@PathVariable float price) {
		return productServe.listProductsPriceMoreThan(price);
	}
}
