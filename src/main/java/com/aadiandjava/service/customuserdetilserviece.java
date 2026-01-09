package com.aadiandjava.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aadiandjava.Enitiy.User;
import com.aadiandjava.Repo.UserRepository;
@Service     
public class customuserdetilserviece implements UserDetailsService{

	@Autowired
	UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	
		Optional<User> byUsername = repository.findByUsername(username);
		
		if (byUsername.isPresent())
		{
			User user = byUsername.get();
			return org.springframework.security.core.userdetails.User.withUsername(user.getUsername()).password(user.getPassword()).roles(user.getRole()).build();
		}
		else
		{
			throw new UsernameNotFoundException("user not found ");
		}
	}

}
