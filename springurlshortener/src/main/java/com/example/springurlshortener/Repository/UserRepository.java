package com.example.springurlshortener.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springurlshortener.Models.User;



public interface UserRepository extends JpaRepository<User,Integer> {
	User findByEmail(String email);

}
