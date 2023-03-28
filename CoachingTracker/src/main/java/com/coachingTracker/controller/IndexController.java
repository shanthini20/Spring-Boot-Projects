package com.coachingTracker.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.coachingTracker.entity.UserEntity;


@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class IndexController {
	
	@GetMapping("/login")
	public String login()
	{
		return "login";
		
	}
	@GetMapping("/tablescreen")
	public String tablescreen()
	{
		return "tablescreen";
		
	}
	@GetMapping("/homescreen")
	public String homescreen()
	{
		return "homescreen";
		
	}
@GetMapping("/finalTable")
public String finalTable()
{
	return "finalTable";
}


}
