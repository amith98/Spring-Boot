package com.example.librarymember.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.librarymember.Models.Library;

public interface LibraryRepository extends JpaRepository<Library,Long> {

}
