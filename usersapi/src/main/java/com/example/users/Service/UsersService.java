package com.example.users.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.users.dto.UsersDto;
import com.example.users.Models.Users;
import com.example.users.Repository.UsersRepository;

@Service
public class UsersService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UsersRepository usersRepository;
	
	public Users save(UsersDto usersDto) {
		Users users = new Users(usersDto.getEmail(),usersDto.getUsername(),passwordEncoder.encode(usersDto.getPassword()));
		return usersRepository.save(users);
		
	}

}
