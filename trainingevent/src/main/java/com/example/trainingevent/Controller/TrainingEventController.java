package com.example.trainingevent.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import jakarta.validation.Valid;
import com.example.trainingevent.UserDetails;
@Controller
public class TrainingEventController {
	@GetMapping("/form")
	public String form(Model model) {
		UserDetails userDetails = new UserDetails();
        model.addAttribute("userDetails", userDetails);
		return "form";
	}
	
	@PostMapping("/submit")
	public String submit(@Valid @ModelAttribute("userDetails") UserDetails userDetails, BindingResult result, Model model) {
		model.addAttribute("userDetails",userDetails);
		if(result.hasErrors()) {
			return "form";
		} else {
			return "success";
		}
	}

}
