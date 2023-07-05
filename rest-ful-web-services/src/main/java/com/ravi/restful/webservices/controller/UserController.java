package com.ravi.restful.webservices.controller;

import java.net.URI;
import java.util.List;
import java.util.Objects;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ravi.restful.webservices.exception.UserNotFoundException;
import com.ravi.restful.webservices.model.User;
import com.ravi.restful.webservices.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

	UserService service;
	
	public UserController(UserService service) {
		this.service=service;
	}
	@GetMapping(path = "/users")
	public List<User> getAllUsers(){
		return service.getAllUsers();
	}
	@GetMapping(path="/users/{id}")
	public User getUser(@PathVariable int id) {
		User user=service.getUser(id);
		if(Objects.isNull(user)) {
			throw new UserNotFoundException("No user exist with given "+id);
		}
		return user;
	}
	@PostMapping(path="/users")
	public ResponseEntity<User> addUser(@Valid @RequestBody User user) {
		User user2= service.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user2.getId()).toUri();
		return ResponseEntity.created(location).body(user2);
	}
	
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable(name = "id") int userId) {
		service.deleteUser(userId);
	}
	
}
