package com.example.springurlshortener.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.springurlshortener.Models.UrlData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UrlDataRepository extends JpaRepository<UrlData,Integer>{
	boolean existsByShorturl(String shorturl);
	
	@Query("SELECT COUNT(p) FROM UrlData p WHERE p.userid = :id")
	int countById(@Param("id")int id);
	
	@Query("SELECT p FROM UrlData p WHERE p.shorturl = :shorturl")
	UrlData findByShorturl(@Param("shorturl")String shorturl);
	
	@Query("SELECT p FROM UrlData p WHERE p.title LIKE %:keyword% OR p.longurl LIKE %:keyword%")
	List<UrlData> findAllByKeyword(@Param("keyword") String keyword);
	
	@Query("SELECT p FROM UrlData p WHERE p.userid=:user_id AND (p.title LIKE %:keyword% OR p.longurl LIKE %:keyword%)")
	Page<UrlData> searchAllFields(@Param("user_id")Integer user_id,@Param("keyword") String keyword,Pageable pageable);
	
	@Query("SELECT p FROM UrlData p WHERE p.userid=:user_id")
	Page<UrlData> findById(@Param("user_id")Integer user_id,Pageable pageable);

}
