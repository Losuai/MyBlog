package com.myBlog.services;

import com.myBlog.models.User;
import com.myBlog.repository.UserRepository;

public class UserServices {
	private UserRepository userRepository = new UserRepository();
	public UserServices() {
		super();
	}
	public boolean login(User user) {
		User exitUser = new User();
		exitUser =  userRepository.findByUsername(user.getUsername());
		if(exitUser == null) {
			return false;
		}else
		if(exitUser.getPassword().equals(user.getPassword())) {
			return true;
		}else {
			return false;
		}
	}
	public boolean register(User user) {
		User exitUser  = new User();
		exitUser =  userRepository.findByUsername(user.getUsername());
		if(exitUser == null) {
			userRepository.Register(user);
			return true;
		}
		else {
			return false;
		}
	}
	public void update(User user) {
		userRepository.updateUserInformation(user);
	}
}
