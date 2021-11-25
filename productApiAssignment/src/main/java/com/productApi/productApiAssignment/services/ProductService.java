package com.productApi.productApiAssignment.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productApi.productApiAssignment.exceptions.ResourceNotFoundException;
import com.productApi.productApiAssignment.model.Product;
import com.productApi.productApiAssignment.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product getProductById(Long id) throws ResourceNotFoundException {
		Optional<Product> op=productRepository.findById(id);
		if(op.isPresent())
			return op.get();
		else
			throw new ResourceNotFoundException("not found product with id :"+id);
	}
	
	
	public String registerProduct(Product p)  {
		Product foundP=null;
		try {
			foundP = getProductById(p.getId());
		} catch (ResourceNotFoundException e) {
			productRepository.save(p);
			return "Registered product "+p.toString()+" succesfully";
		}
		if(foundP!=null)
			return "product has already registered"+p.toString();
		return null;
		
	}
	
	public String updateProduct(Product pd)  {
		Product foundP;
		try {
			foundP = getProductById(pd.getId());
		} catch (ResourceNotFoundException e) {
			return "no element found"+pd.toString();
		}
		if(foundP!=null) {
			productRepository.save(pd);
			return "updated product succefully "+pd.toString();
		}
		return null;
			
	}
	
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	public String deleteProduct(Long id) throws ResourceNotFoundException {
		Product foundP=getProductById(id);
		if(foundP!=null) {
			productRepository.delete(foundP);
			return "deleted Successfully "+foundP.toString();
		}
		else
			return "Product not exist with id "+id;
	}
}
