package com.example.visitor.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class VisitorController {
	@GetMapping("/form")
	public String form() {
		return "form";
	}
	
	@GetMapping("/result")
	public String result(@RequestParam String username,Model model) {
		model.addAttribute("username",username);
		return "result";
	}

}
