package com.AnimeWatchlist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.AnimeWatchlist.entities.User;
import com.AnimeWatchlist.repo.UserRepository;

@Service
public class UserServices{

	@Autowired
	UserRepository ur;
	
	@Autowired
	UserCurrentShowServices ucss;
	
	public User addUser(User user) {
		return ur.save(user);
	}		
	
	public User getUser(String username) {
		return ur.getUserByUsername(username);
	}
	
	public List<User> getAllUsers(){
		return ur.findAll();
	}
		
	public User validateUser(String username, String userPassword) {
		User user = ur.getUserByUsername(username);
		if (user!= null) {
			if(user.getUserPassword().equals(userPassword)) {
				return user;
			}
		}
		return null;
	}
	
	
	
}
