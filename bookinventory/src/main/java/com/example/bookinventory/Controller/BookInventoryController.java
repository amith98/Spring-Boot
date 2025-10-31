package com.example.bookinventory.Controller;

import com.example.bookinventory.Models.Book;
import com.example.bookinventory.Repository.BookRepository;
import com.example.bookinventory.Exception.ProductNotFoundException;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

@RestController
public class BookInventoryController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/addproduct")
	Book newBook(@RequestBody Book newBook) {
		return bookRepository.save(newBook);
	}
	
	@GetMapping("/listproduct")
	List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	Book getBookById(@PathVariable Integer id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException(id));
	}
	
	@PutMapping("/update/{id}")
	Book updateBook(@RequestBody Book newBook,@PathVariable Integer id) {
		return bookRepository.findById(id)
				.map(product -> {
					product.setTitle(newBook.getTitle());
					product.setAuthor(newBook.getAuthor());
					product.setGenre(newBook.getGenre());
					product.setPrice(newBook.getPrice());
					product.setPublishedDate(newBook.getPublishedDate());
					
					return bookRepository.save(product);
				}).orElseThrow(() -> new ProductNotFoundException(id));
		
	}
	
	@DeleteMapping("delete/{id}")
	String deleteBook(@PathVariable Integer id) {
		if(!bookRepository.existsById(id)) {
			throw new ProductNotFoundException(id);
		}
		bookRepository.deleteById(id);
		return "Product with id"+id+"has been deleted successfully!";
	}
	
	@GetMapping("/search")
	List<Book> searchBooks(@Param("keyword") String keyword){
		return bookRepository.findAllByKeyword(keyword);
		
	}

}
