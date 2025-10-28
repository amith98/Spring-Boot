package com.example.fresherportal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.fresherportal.dto.FresherDto;
import com.example.fresherportal.Models.Fresher;
import com.example.fresherportal.Repository.FresherRepository;

@Service
public class FresherService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private FresherRepository fresherRepository;
	
	public Fresher save(FresherDto fresherDto) {
		Fresher fresher = new Fresher(fresherDto.getFullName(),fresherDto.getMobileNumber(),fresherDto.getEmail(),passwordEncoder.encode(fresherDto.getPassword()));
		return fresherRepository.save(fresher);
		
	}

}
