package com.example.bookstore.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class BookStoreController {
	@GetMapping("/home")
	public String home() {
		return "home";
		
	}
	
	@GetMapping("/books")
	public String books() {
		return "book";
		
	}

}
