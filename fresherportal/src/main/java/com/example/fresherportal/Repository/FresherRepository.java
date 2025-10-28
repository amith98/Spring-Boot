package com.example.fresherportal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.fresherportal.Models.Fresher;

public interface FresherRepository extends JpaRepository<Fresher,Long> {

}
