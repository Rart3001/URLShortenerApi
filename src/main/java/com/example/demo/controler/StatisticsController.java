/*
 * @#StatisticsController.java - 2019
 * You can modify, use, reproduce or distribute this software.
 */
package com.example.demo.controler;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.StatisticsDto;
import com.example.demo.service.StatisticsService;

/**
 * @author rrequena - Roberto Requena (rart3001@gmail.com)
 * @version 1.0
 * @since 20/01/19
 */
@CrossOrigin
@RestController
@RequestMapping(value = "api/v1/statistics/")
public class StatisticsController {

	/**
	 * The statisticsService instance
	 */
	private StatisticsService statisticsService;

	/**
	 * Constructor with parameter
	 * @param shortUrlService
	 */
	public StatisticsController(@Autowired StatisticsService statisticsService) {
		super();
		this.statisticsService = statisticsService;
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
	 * Get the statistics for the date
	 * @return statistics
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<StatisticsDto> get(@RequestParam(value = "date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		
		StatisticsDto statisticsDto = statisticsService.getStatistics(date);
		return ResponseEntity.ok(statisticsDto);
	}
	
	/**
	 * Get the statistics for the dates
	 * @return statistics
	 */
	@RequestMapping(value = "/between", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<StatisticsDto> get(@RequestParam(value = "start_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @RequestParam(value = "end_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
		
		StatisticsDto statisticsDto = statisticsService.getStatistics(startDate, endDate);
		return ResponseEntity.ok(statisticsDto);
	}

}
