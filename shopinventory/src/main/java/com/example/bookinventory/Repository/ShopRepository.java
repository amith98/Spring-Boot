package com.example.bookinventory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import com.example.bookinventory.Models.Shop;


public interface ShopRepository extends JpaRepository<Shop,Integer>{
	@Query("SELECT p From Shop p WHERE p.name LIKE %:keyword%")
	List<Shop> findAllByKeyword(@Param("keyword") String keyword);

}
