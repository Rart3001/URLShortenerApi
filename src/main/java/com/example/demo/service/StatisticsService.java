/*
 * @#ShortUrlService.java - 2019
 * You can modify, use, reproduce or distribute this software.
 */
package com.example.demo.service;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StatisticsDto;
import com.example.demo.entity.ShortUrl;
import com.example.demo.repository.ShortUrlRepository;

/**
 * @author rrequena - Roberto Requena (rart3001@gmail.com)
 * @version 1.0
 * @since 20/01/19
 */
@Service
public class StatisticsService {
	
	private static final int EMPTY = 0;

	/**
	 * The shortUrlRepository instance
	 */
	private ShortUrlRepository shortUrlRepository;
	
	/**
	 * Constructor
	 */
	public StatisticsService(@Autowired ShortUrlRepository shortUrlRepository) {
		super();
		this.shortUrlRepository = shortUrlRepository;
	}
	
	/**
	 * Count all created at date
	 * @param created date
	 * @return count
	 */
	public Integer countCreated(@NotNull Date created){
		
		List<ShortUrl> list = shortUrlRepository.findAllByCreated(created);
		
		if(list != null && !list.isEmpty()) {
			return list.size();
		}
		
		return EMPTY;
		
	}
	
	/**
	 * Count all created between start and end dates
	 * @param created date
	 * @return count
	 */
	public Integer countCreatedBetween(@NotNull Date createdStart, @NotNull Date createdEnd){
		
		List<ShortUrl> list = shortUrlRepository.findAllByCreatedBetween(createdStart, createdEnd);
		
		if(list != null && !list.isEmpty()) {
			return list.size();
		}
		
		return EMPTY;
		
	}
	
	/**
	 * Count all accessed at date
	 * @param created date
	 * @return count
	 */
	public Integer countAccessed(@NotNull Date accessed){
		
		List<ShortUrl> list = shortUrlRepository.findAllByAccessed(accessed);
		
		if(list != null && !list.isEmpty()) {
			return list.size();
		}
		
		return EMPTY;
		
	}
	
	/**
	 * Count all accessed between start and end dates
	 * @param created date
	 * @return count
	 */
	public Integer countAccessedBetween(@NotNull Date accessedStart, @NotNull Date accessedEnd){
		
		List<ShortUrl> list = shortUrlRepository.findAllByAccessedBetween(accessedStart, accessedEnd);
		
		if(list != null && !list.isEmpty()) {
			return list.size();
		}
		
		return EMPTY;
		
	}
	
	/**
	 * Get statistics for the date
	 * @param date
	 * @return statistics
	 */
	public StatisticsDto getStatistics(@NotNull Date date) {
		
		int totalCreated = countCreated(date);
		int totalAccessed = countAccessed(date);
		
		return new StatisticsDto(totalCreated, totalAccessed);
	}
	
	/**
	 * Get statistics for the dates
	 * @param startDate
	 * @param endDate
	 * @return statistics
	 */
	public StatisticsDto getStatistics(@NotNull Date startDate, @NotNull Date endDate) {
		
		int totalCreated = countCreatedBetween(startDate, endDate);
		int totalAccessed = countAccessedBetween(startDate, endDate);
		
		return new StatisticsDto(totalCreated, totalAccessed);
	}

}
