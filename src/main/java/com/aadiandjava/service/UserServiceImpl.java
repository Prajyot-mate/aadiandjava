package com.aadiandjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.aadiandjava.Enitiy.User;
import com.aadiandjava.Repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repository;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Override
	public User createduser(User user) {
		
		user.setPassword(encoder.encode(user.getPassword()));
		if (user.getUsername().startsWith("aa"))
		{
			user.setRole("ADMIN");
		}
		else {
			user.setRole("USER");
		}
		
		User save = repository.save(user);
		
		return save;
	}

	

}
