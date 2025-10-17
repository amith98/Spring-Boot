package com.example.studentinfo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.studentinfo.Models.Student;
import java.util.ArrayList;
@Controller
public class StudentInfoController {
	@GetMapping("/student-info")
	public String studentInfo(Model model) {
		Student student = new Student(101,"Anjali Sharma",(float)92.5);
		model.addAttribute("student",student);
		return "studentinfo";	
	}
	
	@GetMapping("/student-list")
	public String studentList(Model model) {
		ArrayList<Student> students = new ArrayList<>();
		students.add(new Student(101,"Anjali Sharma",(float)92.5));
		students.add(new Student(102,"Rohit Mehta",(float)85.0));
		students.add(new Student(103,"Sneha Iyer",(float)78.6));
		model.addAttribute("students", students);
		return "studentlist";
	}

}
