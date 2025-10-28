package com.example.librarymember.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.librarymember.dto.LibraryDto;
import com.example.librarymember.Service.LibraryService;

@Controller
public class LibraryMemberController {
	@Autowired
	private LibraryService libraryService;
	
	@GetMapping("/registration")
	public String getRegistration(@ModelAttribute("library") LibraryDto libraryDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveLibrary(@ModelAttribute("library") LibraryDto libraryDto, Model model) {
		libraryService.save(libraryDto);
		model.addAttribute("message","Welcome, "+libraryDto.getName()+"! Your library membership has been created.");
		return "register";
	}

}
