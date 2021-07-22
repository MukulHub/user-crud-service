package com.user.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.app.entity.User;
import com.user.app.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	public List<User> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/users/{id}")
	public User findById(@PathVariable int id){
		return service.findById(id);
	}
	
	@PostMapping("/users")
	public User saveUser(@RequestBody User user) {
		user.setId(0);
		service.saveUser(user);
		return user;
	}
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User user) {
		service.saveUser(user);
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public String deleteUser(@PathVariable int id){
		User user = service.findById(id);
		if(user == null) {
			throw new RuntimeException("User Not found : "+id);
		}
		service.deleteById(id);
		return "User Deleted with Id :" +id;
	}
}
