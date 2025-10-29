package com.example.user.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.user.dto.UserDto;
import com.example.user.Models.User;
import com.example.user.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	public User save(UserDto userDto) {
		User user = new User(userDto.getFirstName(),userDto.getLastName(),userDto.getAddress(),userDto.getEmail(),passwordEncoder.encode(userDto.getPassword()));
		return userRepository.save(user);
		
	}

}
