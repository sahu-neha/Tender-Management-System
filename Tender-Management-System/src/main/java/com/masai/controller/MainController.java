package com.masai.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	
	
	// trying 
	
	@GetMapping("/tms")
	public String gettingStarted() {
		return "done" ;
	}
}
