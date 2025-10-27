package com.example.mobileshop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mobileshop.Models.Phone;

public interface PhoneRepository extends JpaRepository<Phone,Integer> {

}
