package com.aadiandjava.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aadiandjava.service.JWTUtil;
import com.aadiandjava.service.customuserdetilserviece;

@RestController
public class AuthRestController {

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private customuserdetilserviece userDetailsService;

	@Autowired
	private JWTUtil jwtUtil;

	@PostMapping("/authenticate")
	public String authenticate(@RequestBody AutheticateRequest request) throws Exception {

		try {
			authManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

		} catch (Exception e) {
			throw new Exception("Invalid Username or Password");
		}

		UserDetails user = userDetailsService.loadUserByUsername(request.getUsername());

		String token = jwtUtil.generateToken(user);

		return token;

	}

}