package com.doctor.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class IndexController {

	@GetMapping("/login")
	public String LoginPage() {
		return "login";
	}

	@GetMapping("/newappoint")
	public String newappoint() {
		return "newappoint";
	}

	@GetMapping("/editpatientdata")
	public String editpatientdata() {
		return "editscreen";
	}

	@GetMapping("/patienttable")
	public String table() {
		return "table";
	}

	@GetMapping("/doctable")
	public String doctable() {
		return "doctable";
	}

	@GetMapping("/doctorview")
	public String view() {
		return "doctorview";
	}

	@GetMapping("/doctorreg")
	public String reg() {
		return "doctorreg";
	}

}
