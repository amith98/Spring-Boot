package com.example.school.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.school.Models.School;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface SchoolRepository extends JpaRepository<School,Integer> {
	 @Query("SELECT s FROM School s WHERE s.name LIKE %:keyword%")
	  List<School> findAllByKeyword(@Param("keyword") String keyword);
 
}
