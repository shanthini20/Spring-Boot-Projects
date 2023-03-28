package com.team.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NewController {

	@GetMapping("/first")
	public String firstpage() {
		return "new";
	}

	@GetMapping("/table")
	public String secondpage() {
		return "table";
	}
	@GetMapping("/chart")
	public String chart() {
		return "chart";
	}

	@GetMapping("/editscreen")
	public String thirdpage() {
		return "editscreen";
	}

	@GetMapping("/team")
	public String team() {
		return "teamscreen";
	}
	
	

}
