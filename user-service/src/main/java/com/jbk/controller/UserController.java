package com.jbk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.User;
import com.jbk.service.UserService;

@RestController
@RequestMapping("/users")
@RefreshScope
public class UserController {

	@Autowired
	private UserService userService;

	// add user
	@PostMapping("/add-user")
	// localhost:8080/users/add-user
	public ResponseEntity<Boolean> addUser(@RequestBody User user) {
		Boolean isAdded = userService.addUser(user);
		if (isAdded) {
			return ResponseEntity.ok(isAdded);
		} else {
			return ResponseEntity.status(500).body(false);
		}
	}

	// get user by userId
	// localhost:8081/users/1
	@GetMapping("/{uid}")
	public ResponseEntity<User> getUserById(@PathVariable long uid) {

		System.out.println("Fetching user with ID: " + uid); // Debugging statement);
		User user = userService.getUserById(uid);
		if (user != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// get all users
	// localhost:8080/users/all
	@GetMapping("/all")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUsers = userService.getAllUsers();
		if (allUsers != null && !allUsers.isEmpty()) {
			return ResponseEntity.ok(allUsers);
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	// delete user by userId
	// localhost:8080/users/delete/1
	@DeleteMapping("/delete/{uid}")
	public ResponseEntity<Boolean> deleteUserById( @PathVariable long uid) {
		
		boolean isDeleted = userService.deleteUserById(uid);
		if (isDeleted) {
			return ResponseEntity.ok(isDeleted);
		} else {
			return ResponseEntity.status(500).body(false);
		}
	}
	
	// check if user exists by userId
	@GetMapping("/exists/{uid}")
	public ResponseEntity<Boolean> isUserExists(@PathVariable long uid) {
		boolean exists = userService.isUserExists(uid);
		return ResponseEntity.ok(exists);
	}

}
