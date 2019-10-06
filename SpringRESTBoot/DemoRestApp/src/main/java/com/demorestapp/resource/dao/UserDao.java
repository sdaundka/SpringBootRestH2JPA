package com.demorestapp.resource.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.demorestapp.resource.entities.Address;
import com.demorestapp.resource.entities.Contact;
import com.demorestapp.resource.entities.User;

@Component
public class UserDao {

	private static List<User> userList = new ArrayList<>();
	private static int userId = 1;
	
	static {
		userList.add(new User(1, "Joshua", "Block", new Address("M.G.Road", "Pune", "MH", "411006"), new Contact("8989898989", "joshua@gmail.com"), new Date()));
	}
	
	public List<User> retrieveAllUsers(){
		return userList;
	}

	public User findById(int userId) {
		// TODO Auto-generated method stub
		for (User user : userList) {
			if(user.getUserId() == userId)
				return user;
		}
		return null;
	}

	public User deleteById(int userId) {
		// TODO Auto-generated method stub
		Iterator<User> userIterator = userList.iterator();
		while(userIterator.hasNext()) {
			User user = userIterator.next();
			if(user.getUserId() == userId) {
				userIterator.remove();
				return user;
			}
		}
		return null;
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		if(user.getUserId() == 0)
			user.setUserId(++userId);
		userList.add(user);
		return user;
	}
	
}
