package com.example.users.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.users.Models.Users;

public interface UsersRepository extends JpaRepository<Users,Long> {
	 Users findByUserName(String userName);
}
