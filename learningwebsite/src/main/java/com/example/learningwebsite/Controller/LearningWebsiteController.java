package com.example.learningwebsite.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class LearningWebsiteController {
	@GetMapping("/home")
	public String home(Model model) {
		String welcomeMessage = "A nice message about learning";
		String headingMessage = "Hello welcome from Spring Boot";
		boolean isLoggedIn = true;
		model.addAttribute("welcomeMessage",welcomeMessage);
		model.addAttribute("headingMessage",headingMessage);
		model.addAttribute("isLoggedIn", isLoggedIn);
		return "learningwebsite";
	}

}
