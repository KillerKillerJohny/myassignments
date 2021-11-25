package com.productApi.productApiAssignment.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productApi.productApiAssignment.exceptions.ResourceNotFoundException;
import com.productApi.productApiAssignment.model.Product;
import com.productApi.productApiAssignment.services.ProductService;

@RestController
@RequestMapping("/productAPI")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct( @PathVariable  Long id) throws ResourceNotFoundException  {
		if(id!=null) {
			Product p= productService.getProductById(id);
			return new ResponseEntity<>(p,HttpStatus.FOUND);
		}
		else
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/")
	public String registerProduct(@Valid @RequestBody Product prod) throws ResourceNotFoundException{
		return productService.registerProduct(prod);
	}
	
	@PutMapping("/{id}")
	public String updateProduct(@Valid @RequestBody Product prod,@PathVariable Long id) throws ResourceNotFoundException{
		if(id!=prod.getId()) {
			return "path id "+id+" value didnt match with body id "+prod.getId();
		}
		return productService.updateProduct(prod);
	}
	
	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable Long id) throws ResourceNotFoundException {
		return productService.deleteProduct(id);
	}
	
	
}
