package com.productApi.productApiAssignment;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import com.productApi.productApiAssignment.model.Product;


@SpringBootTest
public class ProductApiAssignmentApplicationTests {
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	public static String url="http://localhost:8081/productAPI/";
	
//	@LocalServerPort
//	private int port;
	
//	posting product data
	@Test
	public void postProductTest() {
		Product p=new Product(1L,"sample1","this is sample description",45.00);
		String res=this.restTemplate.postForObject(url, p,String.class);
		assertEquals(res,"Registered product "+p.toString()+" succesfully");
	}
	
	
//	getting product data
	@Test
	public void getAllProductsTest() {
		assertThat(this.restTemplate.getForObject(url,List.class)).size().isEqualTo(2);
	}
	
//updating the data
	
	@Test
	public void updateProductTest() {
		Product p=new Product(2l,"sample2","this is description",45.00);
		this.restTemplate.put(url+"/"+p.getId(), p);
		System.out.println("updated succesfully");
	}
	
//delete the data
	
	@Test
	public void deleteProductTest() {
		this.restTemplate.delete(url+"/"+2);
		System.out.println("deleted successfully");
	}
	
	
	
	
	
	

}
