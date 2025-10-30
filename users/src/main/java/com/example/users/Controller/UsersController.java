package com.example.users.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.users.dto.UsersDto;
import com.example.users.Service.UsersService;

@Controller
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@GetMapping("/registration")
	public String getRegistration(@ModelAttribute("users") UsersDto usersDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveLibrary(@ModelAttribute("users") UsersDto usersDto, Model model) {
		usersService.save(usersDto);
		model.addAttribute("message","Thanks for registering,"+usersDto.getUserName()+"!");
		return "register";
	}
	
	  @GetMapping("/login")
	    public String login() {
	        return "login";
	    }
	  
	  @GetMapping("/create")
	  public String homePage() {
		  return "home";
	  }

}
