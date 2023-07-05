package com.ravi.restful.webservices.controller;

import java.net.URI;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ravi.restful.webservices.service.ProductService;
import com.ravi.restful.webservices.service.UserService;

import jakarta.validation.Valid;

import com.ravi.restful.webservices.model.Product;
import com.ravi.restful.webservices.model.User;

@RestController
public class ProductController {

	/**
	 * Add resource method to add products
	 * product is an request body object- means model object as parameter
	 * Follow below steps
	 * 1. Create model class with name Product under model package
	 * 2. Add following parameters in that class
	 * 		id
	 * 		name
	 * 		shortDescription
	 * 		price
	 * 		color
	 * 		sellerName
	 * 3. Create method with product parameter with annoation @RequestBody
	 * 4. implement service and logic to store product in map object (take user service as reference)
	 * 5. call productService.addProduct(product) by passing product object
	 * 6. return product response as it is with 201 status code
	 */
	
	/**
	 * Add resource method to get all products from product service map object (take userController and UserService as reference to return list of data )
	 * 
	 */
	
	
	/**
	 * Add resoruce method to update a product (same follow user controller and service to get idea)
	 */
	
	
	ProductService productservice;
	public ProductController(ProductService productservice) {
		this.productservice=productservice;
	}
	@GetMapping(path ="/products")
	public Map<Integer,Product> getProducts(){
		return productservice.getAllProducts();
	}
	@PostMapping(path="/products")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
		Product p1= productservice.addProduct(product);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p1.getId()).toUri();
		return ResponseEntity.created(location).body(p1);
	}
}
