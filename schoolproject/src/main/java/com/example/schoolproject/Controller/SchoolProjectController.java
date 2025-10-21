package com.example.schoolproject.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class SchoolProjectController {
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	@GetMapping("/product-details")
	public String products() {
		return "product";
	}

}
