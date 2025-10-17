package com.example.grocerystore.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.example.grocerystore.Models.Product;
import java.util.ArrayList;
@Controller
public class ProductController {
	@GetMapping("/single-product")
	public String getSingleProduct(Model model) {
		Product product = new Product(101,"Sugar",(float)55.5);
		model.addAttribute("product",product);
		return "singleprod";
	}
	
	@GetMapping("/product-list")
	public String getProductList(Model model) {
		ArrayList<Product> products = new ArrayList<>();
		products.add(new Product(101,"Sugar",(float)55.5));
		products.add(new Product(102,"Salt",(float)20.0));
		products.add(new Product(103,"Wheat Flour",(float)38.75));
		model.addAttribute("products",products);
		return "productlist";
	}

}
