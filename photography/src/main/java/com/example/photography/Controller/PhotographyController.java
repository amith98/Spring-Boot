package com.example.photography.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class PhotographyController {
	@GetMapping("/start")
	public String start() {
		return "redirect:/welcome";
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
}
