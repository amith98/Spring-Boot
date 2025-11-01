package com.example.userreg.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.userreg.Models.User;
import com.example.userreg.Repository.UserRepository;

@RestController
public class UserAPIController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/registration")
	public ResponseEntity<?> register(@RequestBody User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		return ResponseEntity.ok("User registerd successfully!! Username:"+user.getFirstname()+" Email: "+user.getEmail());
		
	}


}
