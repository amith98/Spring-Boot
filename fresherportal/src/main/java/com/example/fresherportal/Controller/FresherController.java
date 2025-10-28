package com.example.fresherportal.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.fresherportal.dto.FresherDto;
import com.example.fresherportal.Service.FresherService;

@Controller
public class FresherController {
	@Autowired
	private FresherService fresherService;
	
	@GetMapping("/registration")
	public String getRegistration(@ModelAttribute("fresher") FresherDto fresherDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveLibrary(@ModelAttribute("fresher") FresherDto fresherDto, Model model) {
		fresherService.save(fresherDto);
		model.addAttribute("message","Thanks for registering,"+fresherDto.getFullName()+"! You can now apply for jobs.");
		return "register";
	}

}
