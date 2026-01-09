package com.aadiandjava.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aadiandjava.Enitiy.User;
import com.aadiandjava.service.UserService;

@RestController
public class Restcontroller {

	@Autowired
	UserService service;
	
	@PostMapping("/create")
	public ResponseEntity<User> createuser(@RequestBody User user)
	{
		User saveduser = service.createduser(user);
		return new ResponseEntity<User>(saveduser, HttpStatus.CREATED);
	}
	
}
