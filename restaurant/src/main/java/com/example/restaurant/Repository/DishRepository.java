package com.example.restaurant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.restaurant.Models.Dish;


public interface DishRepository extends JpaRepository<Dish,Integer> {

}
