package com.ravi.restful.webservices.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.ravi.restful.webservices.model.Product;
import com.ravi.restful.webservices.model.User;

@Component
public class ProductService {

	private static Map<Integer,Product> productmap=new HashMap<>();
	
	private static int counter=0;
	static {
		productmap.put(++counter, new Product("vinod","hi ",1234,"red","soujanya"));
		productmap.put(++counter, new Product("vinod","hi ",1234,"red","soujanya"));
	}
	public Map<Integer,Product> getAllProducts(){
		return productmap;
	}
	
	public Product addProduct(Product product) {
		product.setId(++counter);
		productmap.put(product.getId(), product);
		return product;
	}
}
