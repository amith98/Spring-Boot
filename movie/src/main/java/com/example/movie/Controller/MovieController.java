package com.example.movie.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
@Controller
public class MovieController {
	@GetMapping("/movie")
	public String movie(Model model) {
		String movieTitle = "Movie Title";
		String movieFirstLine = "Movie First Line Description";
		String movieDescription = "Movie full Description";
		boolean isLoggedIn = true;
		model.addAttribute("movieTitle",movieTitle);
		model.addAttribute("movieFirstLine",movieFirstLine);
		model.addAttribute("movieDescription",movieDescription);
		model.addAttribute("isLoggedIn",isLoggedIn);
		return "movie";
		
	}

}
