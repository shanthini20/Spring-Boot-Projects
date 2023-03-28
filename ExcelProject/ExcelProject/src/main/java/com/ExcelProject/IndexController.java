package com.ExcelProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import jakarta.persistence.spi.PersistenceProvider;
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class IndexController {

	
	@GetMapping("/datascreen")
	public String datascreen()
	{
		return "datascreen";
	}
	@GetMapping("/index")
	public String index()
	{
		return "index";
	}
	@GetMapping("/editscreen")
	public String editscreen()
	{
		return "editscreen";
	}
}
