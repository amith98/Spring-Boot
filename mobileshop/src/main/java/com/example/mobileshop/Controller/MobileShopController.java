package com.example.mobileshop.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.mobileshop.Models.Phone;
import com.example.mobileshop.Repository.PhoneRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class MobileShopController {
	
	@Autowired
	private PhoneRepository phoneRepository;
	
	@GetMapping("/create")
	public String createFrontPage(Model model) {
		model.addAttribute("message","Enter the Phone Details");
		return "create";
	}
	
	@PostMapping("/create")
	public String createPageData(Model model, Phone phoneData) {
		phoneRepository.save(phoneData);
		model.addAttribute("message","The Phone " + phoneData.getName() + " has been created successfully!");
		return "create";
	}
	
	@GetMapping("/all") 
	public String listAllPhones(Model model) {
		List<Phone> phoneList = phoneRepository.findAll();
		model.addAttribute("phoneList", phoneList);
		return "list";
	}
	
	@GetMapping("/update/{id}")
	public String updatePhoneDetail(@PathVariable Integer id, Model model) {
		Optional<Phone> optionalPhoneDetails = phoneRepository.findById(id);
		if(optionalPhoneDetails.isPresent()) {
			model.addAttribute("phoneDetails", optionalPhoneDetails.get());
			return "update";
		}
		return "redirect:/all";
		
	}
	
	@PostMapping("/update/{id}")
	public String updatePhoneDetail(@PathVariable Integer id, Phone phoneData) {
		Optional<Phone> optionalPhoneDetails = phoneRepository.findById(id);
		if(optionalPhoneDetails.isPresent()) {
			Phone phoneDetails = optionalPhoneDetails.get();
			phoneDetails.setId(phoneData.getId());
			phoneDetails.setName(phoneData.getName());
			phoneDetails.setDescription(phoneData.getDescription());
			phoneDetails.setPrice(phoneData.getPrice());
			phoneRepository.save(phoneDetails);
		}
		return "redirect:/all";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePhoneDetail(@PathVariable Integer id, Model model) {
		Optional<Phone> optionalPhoneDetails = phoneRepository.findById(id);
		if(optionalPhoneDetails.isPresent()) {
			model.addAttribute("phoneDetails", optionalPhoneDetails.get());
			return "delete";
		}
		return "redirect:/all";
		
	}
	
	@PostMapping("/delete/{id}")
	public String deletePhoneDetail(@PathVariable Integer id) {
		phoneRepository.deleteById(id);
		return "redirect:/all";
	}

}
