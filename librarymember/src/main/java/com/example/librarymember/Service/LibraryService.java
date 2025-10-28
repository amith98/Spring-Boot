package com.example.librarymember.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.librarymember.dto.LibraryDto;
import com.example.librarymember.Models.Library;
import com.example.librarymember.Repository.LibraryRepository;

@Service
public class LibraryService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private LibraryRepository libraryRepository;
	
	public Library save(LibraryDto libraryDto) {
		Library library = new Library(libraryDto.getName(),libraryDto.getDateOfBirth(),libraryDto.getAddress(),libraryDto.getEmail(),passwordEncoder.encode(libraryDto.getPassword()));
		return libraryRepository.save(library);
		
	}

}
