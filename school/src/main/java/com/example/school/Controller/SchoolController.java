package com.example.school.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.school.Models.School;
import com.example.school.Repository.SchoolRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.repository.query.Param;
@Controller
public class SchoolController {
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	@GetMapping("/create")
	public String createFrontPage(Model model) {
		model.addAttribute("message","Enter the Student Details");
		return "create";
	}
	
	@PostMapping("/create")
	public String createPageData(Model model, School schoolData) {
		schoolRepository.save(schoolData);
		model.addAttribute("message","The Student " + schoolData.getName() + " has been created successfully!");
		return "create";
	}
	
	@GetMapping("/all") 
	public String listAllStudents(@Param("keyword") String keyword,Model model) {
		List<School> schoolList;
		if(keyword != null && !keyword.isEmpty()) {
			schoolList = schoolRepository.findAllByKeyword(keyword);
		} else {
			schoolList = schoolRepository.findAll();
		}
		model.addAttribute("schoolList", schoolList);
		return "list";
	}
	
	@GetMapping("/update/{id}")
	public String updateSchoolDetail(@PathVariable Integer id, Model model) {
		Optional<School> optionalSchoolDetails = schoolRepository.findById(id);
		if(optionalSchoolDetails.isPresent()) {
			model.addAttribute("schoolDetails", optionalSchoolDetails.get());
			return "update";
		}
		return "redirect:/all";
		
	}
	
	@PostMapping("/update/{id}")
	public String updateSchoolDetail(@PathVariable Integer id, School schoolData) {
		Optional<School> optionalSchoolDetails = schoolRepository.findById(id);
		if(optionalSchoolDetails.isPresent()) {
			School schoolDetails = optionalSchoolDetails.get();
			schoolDetails.setId(schoolData.getId());
			schoolDetails.setName(schoolData.getName());
			schoolDetails.setStandard(schoolData.getStandard());
			schoolDetails.setAge(schoolData.getAge());
			schoolRepository.save(schoolDetails);
		}
		return "redirect:/all";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSchoolDetail(@PathVariable Integer id, Model model) {
		Optional<School> optionalSchoolDetails = schoolRepository.findById(id);
		if(optionalSchoolDetails.isPresent()) {
			model.addAttribute("schoolDetails", optionalSchoolDetails.get());
			return "delete";
		}
		return "redirect:/all";
		
	}
	
	@PostMapping("/delete/{id}")
	public String deletePhonSchoolDetail(@PathVariable Integer id) {
		schoolRepository.deleteById(id);
		return "redirect:/all";
	}

}
