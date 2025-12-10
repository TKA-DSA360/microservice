package com.jbk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.entity.User;
import com.jbk.repositiory.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	// Service methods will go here

	// add user
	public Boolean addUser(User user) {
		User savedUser = userRepository.save(user);
		if (savedUser != null) {
			return true;
		}
		return null;

	}

	// get user by userId
	public User getUserById(long uid) {
		User user = userRepository.findById(uid).orElse(null);
		return user;
	}

	// get all users
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		return users;
	}

	public boolean deleteUserById(long uid) {
		boolean exists = userRepository.existsById(uid);
		if (exists) {
			userRepository.deleteById(uid);
			return true;
		}
		return false;
	}

	public boolean isUserExists(long uid) {
		return userRepository.existsById(uid);
	}
}
