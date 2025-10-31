package com.example.bookinventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.example.bookinventory.Models.Book;


public interface BookRepository extends JpaRepository<Book,Integer>{
	@Query("SELECT b From Book b WHERE b.title LIKE %:keyword%")
	List<Book> findAllByKeyword(@Param("keyword") String keyword);

}
