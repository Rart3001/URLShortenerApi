/*
 * @#ShortUrlService.java - 2019
 * You can modify, use, reproduce or distribute this software.
 */
package com.example.demo.service;

import java.security.InvalidParameterException;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ShortUrl;
import com.example.demo.repository.ShortUrlRepository;

/**
 * @author rrequena - Roberto Requena (rart3001@gmail.com)
 * @version 1.0
 * @since 20/01/19
 */
@Service
public class ShortUrlService {

	/**
	 * The shortUrlRepository instance
	 */
	private ShortUrlRepository shortUrlRepository;
	
	/**
	 * The urlValidator instance
	 */
	private UrlValidator urlValidator;
	
	/**
	 * Constructor
	 */
	public ShortUrlService(@Autowired ShortUrlRepository shortUrlRepository) {
		super();
		this.shortUrlRepository = shortUrlRepository;
		this.urlValidator = new UrlValidator();
	}
	
	/**
	 * Short and save a URL 
	 * @param url
	 * @return shorted URL id
	 */
	public String save(@NotNull String url){
		
		if(!urlValidator.isValid(url)) {
			throw new InvalidParameterException("A valid url is required!");
		}
				
		ShortUrl shortUrl = new ShortUrl();
		shortUrl.setId(RandomStringUtils.randomAlphabetic(6));
		shortUrl.setOriginalUrl(url);
		
		shortUrlRepository.save(shortUrl);
		
		return shortUrl.getId();
		
	}
	
	/**
	 * Find a shorted URL
	 * @param id
	 * @return original URL
	 */
	public String getOriginalURL(@NotNull String id) {
		
		ShortUrl shortUrl = shortUrlRepository.findById(id).get();
		shortUrl.setAccessed(new Date(System.currentTimeMillis()));
		shortUrlRepository.save(shortUrl);
		return shortUrl.getOriginalUrl();
	}

}
