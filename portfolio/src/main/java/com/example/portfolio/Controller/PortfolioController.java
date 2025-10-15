package com.example.portfolio.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class PortfolioController {
	@GetMapping("/start")
	public String start() {
		return "redirect:/portfolio";
	}
	
	@GetMapping("/portfolio")
	public String portfolio() {
		return "portfolio";
	}

}
