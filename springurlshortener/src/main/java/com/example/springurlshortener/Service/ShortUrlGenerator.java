package com.example.springurlshortener.Service;

import org.springframework.stereotype.Service;
import java.security.SecureRandom;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.springurlshortener.Repository.UrlDataRepository;

@Service
public class ShortUrlGenerator {
	
	@Autowired
	UrlDataRepository urlDataRepository;
	
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int SHORTURL_LENGTH = 10;
    private static final SecureRandom RANDOM = new SecureRandom();

    //Method to generate random short url
    private String generateRandomString() {
        StringBuilder stringBuilder = new StringBuilder(SHORTURL_LENGTH);

        for (int i = 0; i < SHORTURL_LENGTH; i++) {
            int randomIndex = RANDOM.nextInt(CHARACTERS.length());
            stringBuilder.append(CHARACTERS.charAt(randomIndex));
        }

        return stringBuilder.toString();
    }
    
    // Generate and return the short url
    public String generateShortUrl() {
            String shortUrl;
            do {
            	shortUrl = generateRandomString();
            } while (urlDataRepository.existsByShorturl(shortUrl)); // Check if token exists in DB
            
            return shortUrl;
        
    }
    
}
