package com.user.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.user.app.entity.User;
import com.user.app.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;


	@Transactional
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Transactional
	public User findById(int id) {
		return userRepository.findById(id).get();
	}

	@Transactional
	public void saveUser(User user) {
		userRepository.save(user);
	}

	@Transactional
	public void deleteById(int id) {
		userRepository.deleteById(id);
	}

}
