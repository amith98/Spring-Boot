package com.example.restaurant.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.restaurant.Repository.DishRepository;
import com.example.restaurant.Models.Dish;
import org.springframework.ui.Model;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ResturantController {
	
	@Autowired
	private DishRepository dishRepository;
	
	@GetMapping("/create")
	public String createDish(Model model) {
		model.addAttribute("message","Enter the details of the dish");
		return "create";
	}
	
	@PostMapping("/create") 
		public String createDishItems(Dish dishData, Model model) {
			model.addAttribute("message", "Dish successfully created!");
			Dish dishDataDetails = new Dish();
			dishDataDetails.setDishName(dishData.getDishName());
			dishDataDetails.setPrice(dishData.getPrice());
			dishRepository.save(dishDataDetails);
			return "create";
		}
	
	@GetMapping("/all")
	public String dishDetails(Model model) {
		List<Dish> dishDetailList = dishRepository.findAll();
		model.addAttribute("dishDetailList", dishDetailList);
		return "list";
		
	}
	
	@GetMapping("/dish/{dishName}/{price}")
	public String shareUrl(@PathVariable String dishName, @PathVariable String price, Model model) {
		model.addAttribute("dishName", dishName);
		model.addAttribute("dishPrice", price);
		
		return "share";
		
	}

	

}
