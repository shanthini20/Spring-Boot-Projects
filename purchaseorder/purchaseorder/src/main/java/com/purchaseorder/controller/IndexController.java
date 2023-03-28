package com.purchaseorder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class IndexController {

	
	@GetMapping("/index")
	public String firstpage() {
		return "index";
	}
	

	@GetMapping("/table")
	public String second() {
		return "table";
	}

	@GetMapping("/test")
	public String test() {
		return "test";
	}
}
