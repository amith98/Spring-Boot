package com.example.student.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
@Controller
public class Student {
	@GetMapping("/student")
	public String student() {
		return "Student";
	}

}
