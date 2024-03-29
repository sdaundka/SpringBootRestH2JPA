package com.demorestapp.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demorestapp.resource.dao.UserDao;
import com.demorestapp.resource.dao.UserH2Repository;
import com.demorestapp.resource.entities.User;
import com.demorestapp.resource.exception.UserNotFoundException;

@RestController
public class UserController {

	/*@Autowired
	private UserDao userDao;*/
	
	@Autowired
	private UserH2Repository userDao;
	
	@GetMapping(path="users")
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
	@GetMapping(path="users/{userId}")
	public User findUserById(@PathVariable int userId) {
		Optional<User> userOptional = userDao.findById(userId);
		
		if(userOptional.isEmpty())
			throw new UserNotFoundException("User is not found");
		User user = userOptional.get();
		return user;
	}
	
	@PostMapping(path="users")
	public User addUser(@RequestBody User user) {
		User savedUser = userDao.save(user);
		return savedUser;
		
	}
	
	@DeleteMapping(path="users/{userId}")
	public void deleteUserById(@PathVariable int userId) {
		userDao.deleteById(userId);
	}
	
	
	
}
