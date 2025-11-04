package com.example.users.Controller;

import com.example.users.Models.Users;
import com.example.users.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsersAPIController {
	  @Autowired
	    private UsersRepository usersRepository;

	    @Autowired
	    private PasswordEncoder passwordEncoder;
	    
	    @PostMapping("/registration")
	    public ResponseEntity<?> register(@RequestBody Users user) {
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        usersRepository.save(user);
	        return ResponseEntity.ok("User registered successfully");
	    }

}
