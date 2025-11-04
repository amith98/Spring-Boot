package com.example.librarybooks.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;



@Controller
public class BookController {
	public String title = "Data Programming";
	public String author = "Carl Marks";
	public String description = "Book about Data programming";
	public String price = "299";
	public String publishedDate = "22-08-2021";
	
	@GetMapping("/books")
	public String getBooks(Model model) {
		model.addAttribute("title",title);
		model.addAttribute("author",author );
		model.addAttribute("description", description);
		model.addAttribute("price", price);
		model.addAttribute("publishedDate",publishedDate );
		return "books";
	}
	

}
