package com.example.springurlshortener.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import java.security.Principal;
import java.util.Optional;
import org.springframework.data.domain.Page;

import org.springframework.web.servlet.view.RedirectView;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;

import com.example.springurlshortener.Models.User;
import com.example.springurlshortener.Models.UrlData;
import com.example.springurlshortener.Repository.UserRepository;
import com.example.springurlshortener.Repository.UrlDataRepository;
import com.example.springurlshortener.Service.ShortUrlGenerator;
import com.example.springurlshortener.Service.PagingService;

@Controller
public class SpringUrlController {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UrlDataRepository urlDataRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	ShortUrlGenerator shortUrlGenerator;
	
	@Autowired
	PagingService pagingService;
	
	@GetMapping("/registration")
	public String getRegistrationPage(User user,Model model) {
		model.addAttribute("message","Enter the user details for registration");
		return "register";
	}
	
	@PostMapping("/registration")
	public String getDetailsFromRegPage(User userData,Model model) {
		User user = new User(userData.getEmail(),passwordEncoder.encode(userData.getPassword()));
		userRepository.save(user);
		model.addAttribute("message","User has been successfully registered");
		//return "register";
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/homepage")
	public String homePage(Model model,Principal principal) {
		String username;
		if(principal != null) {
			username = principal.getName();
		} else {
			username = "";
		}
		model.addAttribute("user", username);
		return "homepage";
	}
	
	//Checking the count of url with userid and redirect to /create
	@GetMapping("/check")
	public String checkUrlCount(Principal principal,Model model) {
		String username = principal.getName();
		User user = userRepository.findByEmail(username);
		Integer user_id = user.getUserid(); 
		int count = urlDataRepository.countById(user_id);
		if(count < 5) {
			return "redirect:/create";
		} else {
			model.addAttribute("user", username);
			model.addAttribute("checkMessage", "Reached limit can add only 5 URLs");
			return "homepage";
			
		}
		
	}
	
	@GetMapping("/create")
	public String getCreatePage(Model model) {
		model.addAttribute("message", "Enter the URL details");
		return "create";
	}
	
	@PostMapping("/create")
	public String createShortUrl(String title,String longurl,Model model,Principal principal) {
		String username = principal.getName();
		User user = userRepository.findByEmail(username);
		Integer user_id = user.getUserid();
		int count = urlDataRepository.countById(user_id);
		if(count < 5) {
			String local_title = title;
			String local_longurl = longurl;
			String local_shorturl = shortUrlGenerator.generateShortUrl();
			UrlData urlData = new UrlData();
			urlData.setUserid(user_id);
			urlData.setTitle(local_title);
			urlData.setLongurl(local_longurl);
			urlData.setShorturl(local_shorturl);
			urlData.setCreatedTime();
			urlDataRepository.save(urlData);
			model.addAttribute("message", "The URL has been successfully added ");
			return "create";
		} else {
			model.addAttribute("user", username);
			model.addAttribute("checkMessage", "Reached limit can add only 5 URLs");
			return "homepage";
		}
	
	}
	
//	@GetMapping("/listall")
//	public String listAllUrls(Model model,@Param("keyword")String keyword) {
//		List<UrlData> urlList;
//		if(keyword != null && !keyword.isEmpty()) {
//			urlList = urlDataRepository.findAllByKeyword(keyword); 
//		} else {
//			urlList = urlDataRepository.findAll();
//		}
//		 
//		model.addAttribute("urlList", urlList);
//		return "list";
//	}
	
	@GetMapping("/listall")
	public String listAllUrls(Model model,Principal principal,
			@RequestParam(required = false) String keyword,
			@RequestParam(defaultValue = "1") int pageNum,
			@RequestParam(defaultValue = "2") int pageSize,
			@RequestParam(defaultValue = "id") String sortField,
			@RequestParam(defaultValue = "asc") String sortDir) {
		String username = principal.getName();
		User user = userRepository.findByEmail(username);
		Integer user_id = user.getUserid(); 
		Page<UrlData> page = pagingService.findPaginated(user_id,keyword,pageNum, pageSize, sortField, sortDir);
		model.addAttribute("page", page);
		model.addAttribute("currentPage", pageNum);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("urlList", page.getContent());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		return "list";
	
	}
	
	@GetMapping("/{shorturl}")
	public RedirectView shortToOriginalRedirect(@PathVariable String shorturl) {
		UrlData urlData = urlDataRepository.findByShorturl(shorturl);
		String long_url = urlData.getLongurl();
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(long_url);
		return redirectView;
	}
	
	@GetMapping("/update/{id}")
	public String updateUrlDetail(@PathVariable Integer id, Model model) {
		Optional<UrlData> optionalUrlDetails = urlDataRepository.findById(id);
		if(optionalUrlDetails.isPresent()) {
			model.addAttribute("urlDetails", optionalUrlDetails.get());
			return "update";
		}
		return "redirect:/listall";
		
	}
	
	@PostMapping("/update/{id}")
	public String updateUrlDetail(@PathVariable Integer id, UrlData urlData) {
		Optional<UrlData> optionalUrlDetails = urlDataRepository.findById(id);
		if(optionalUrlDetails.isPresent()) {
			UrlData urlDetails = optionalUrlDetails.get();
			
			if(!urlDetails.getTitle().equals(urlData.getTitle())) {
				urlDetails.setTitle(urlData.getTitle());
			}
			if(!urlDetails.getLongurl().equals(urlData.getLongurl())) {
				urlDetails.setLongurl(urlData.getLongurl());
				String local_shorturl = shortUrlGenerator.generateShortUrl();
				urlDetails.setShorturl(local_shorturl);
			}
			urlDataRepository.save(urlDetails);
		}
		return "redirect:/listall";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUrlDetail(@PathVariable Integer id, Model model) {
		Optional<UrlData> optionalUrlDetails = urlDataRepository.findById(id);
		if(optionalUrlDetails.isPresent()) {
			model.addAttribute("urlDetails", optionalUrlDetails.get());
			return "delete";
		}
		return "redirect:/listall";
	}
	
	@PostMapping("/delete/{id}")
	public String deleteUrlDetail(@PathVariable Integer id) {
		urlDataRepository.deleteById(id);
		return "redirect:/listall";
	}

}
