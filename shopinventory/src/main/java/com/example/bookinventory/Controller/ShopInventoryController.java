package com.example.bookinventory.Controller;

import com.example.bookinventory.Models.Shop;
import com.example.bookinventory.Repository.ShopRepository;
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
public class ShopInventoryController {
	
	@Autowired
	private ShopRepository shopRepository;
	
	@PostMapping("/addproduct")
	Shop newProduct(@RequestBody Shop newProduct) {
		return shopRepository.save(newProduct);
	}
	
	@GetMapping("/listproduct")
	List<Shop> getAllProducts() {
		return shopRepository.findAll();
	}
	
	@GetMapping("/product/{id}")
	Shop getProductById(@PathVariable Integer id) {
		return shopRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException(id));
	}
	
	@PutMapping("/update/{id}")
	Shop updateProduct(@RequestBody Shop newProduct,@PathVariable Integer id) {
		return shopRepository.findById(id)
				.map(product -> {
					product.setName(newProduct.getName());
					product.setDescription(newProduct.getDescription());
					product.setCategory(newProduct.getCategory());
					product.setPrice(newProduct.getPrice());
					product.setExpiryDate(newProduct.getExpiryDate());
					product.setStock(newProduct.getStock());
					return shopRepository.save(product);
				}).orElseThrow(() -> new ProductNotFoundException(id));
		
	}
	
	@DeleteMapping("delete/{id}")
	String deleteProduct(@PathVariable Integer id) {
		if(!shopRepository.existsById(id)) {
			throw new ProductNotFoundException(id);
		}
		shopRepository.deleteById(id);
		return "Product with id"+id+"has been deleted successfully!";
	}
	
	@GetMapping("/search")
	List<Shop> searchProducts(@Param("keyword") String keyword){
		return shopRepository.findAllByKeyword(keyword);
		
	}

}
