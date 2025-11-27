package com.example.springurlshortener.Service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import com.example.springurlshortener.Repository.UrlDataRepository;
import com.example.springurlshortener.Models.UrlData;

@Service
public class PagingService {
	
	@Autowired
	UrlDataRepository urlDataRepository;
	
	public Page<UrlData> findPaginated(Integer user_id,String keyword,int pageNum,int pageSize,String sortField,String sortDir) {
		Sort sort = Sort.by(sortField);
		sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? sort.ascending():sort.descending();
		Pageable pageable = PageRequest.of(pageNum-1, pageSize,sort);
		if(keyword != null && !keyword.isEmpty()) {
			return urlDataRepository.searchAllFields(user_id,keyword,pageable);
		} else {
			return urlDataRepository.findById(user_id,pageable);
		}
		
	}
	
	
}
