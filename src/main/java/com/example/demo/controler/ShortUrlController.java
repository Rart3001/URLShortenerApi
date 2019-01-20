/*
 * @#ShortUrlController.java - 2019
 * You can modify, use, reproduce or distribute this software.
 */
package com.example.demo.controler;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ShortUrlService;

/**
 * @author rrequena - Roberto Requena (rart3001@gmail.com)
 * @version 1.0
 * @since 20/01/19
 */
@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/short/")
public class ShortUrlController {
	
	/**
	 * The shortUrlService instance
	 */
	private ShortUrlService shortUrlService;

	/**
	 * Constructor with parameter
	 * @param shortUrlService
	 */
	public ShortUrlController(@Autowired ShortUrlService shortUrlService) {
		super();
		this.shortUrlService = shortUrlService;
	}
	
	/**
	 * Get the service status
	 * @return string
	 */
	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public ResponseEntity<String> get() {
		return ResponseEntity.ok("Service running! :)");
	}
	
	/**
	 * Create a shorted URL
	 * @param url
	 * @param request
	 * @return shorted URL
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<String> create(@RequestBody(required=true) String url, HttpServletRequest request) {
		
		String shortUrl = request.getRequestURL() + shortUrlService.save(url);
		return ResponseEntity.ok(shortUrl);
	}
	
	/**
	 * Get the original URL
	 * @param id
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public void find(@PathVariable("id") String id, HttpServletResponse response) throws IOException {
		
		String location = shortUrlService.getOriginalURL(id);
		response.sendRedirect(location);
	}

}
