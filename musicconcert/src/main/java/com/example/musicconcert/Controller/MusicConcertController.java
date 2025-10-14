package com.example.musicconcert.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class MusicConcertController {
	@GetMapping("/concert")
	public String concert() {
		return "MusicConcert";
	}
}
