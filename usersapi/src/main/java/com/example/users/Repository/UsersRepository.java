package com.example.users.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.users.Models.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {
	 Users findByEmail(String email);
	 Users findByToken(String token);
	 boolean existsByToken(String token);
}
