package com.ravi.restful.webservices.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.ravi.restful.webservices.model.User;

@Component
public class UserService {

	private static List<User> users=new ArrayList<>();
	private static int counter=0;
	static {
		users.add(new User(++counter, "Dam", LocalDate.now().minusYears(30)));
		users.add(new User(++counter, "Jim", LocalDate.now().minusYears(25)));
		users.add(new User(++counter, "Ravi", LocalDate.now().minusYears(20)));
	}
	public List<User> getAllUsers(){
		return users;
	}
	public User getUser(int id) {
		Optional<User> user1=users.stream().filter(user-> user.getId()==id).findFirst();
		return user1.isPresent() ? user1.get(): null;
	}
	public User addUser(User user) {
		user.setId(++counter);
		users.add(user);
		return user;
	}
	public void deleteUser(int id) {
		users.removeIf(user-> user.getId()==id);
	}
	
}
