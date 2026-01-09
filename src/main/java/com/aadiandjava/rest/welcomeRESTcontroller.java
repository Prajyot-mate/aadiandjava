package com.aadiandjava.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class welcomeRESTcontroller {

	
	@GetMapping("/welcome")
	public String welcome()
	{
		return "welcome we are learing jwt";
	}
}
