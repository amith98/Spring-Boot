package com.example.user.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.user.dto.UserDto;
import com.example.user.Service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/registration")
	public String getRegistration(@ModelAttribute("user") UserDto userDto) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveLibrary(@ModelAttribute("user") UserDto userDto, Model model) {
		userService.save(userDto);
		model.addAttribute("message","Thanks for registering,"+userDto.getFirstName()+"!");
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
