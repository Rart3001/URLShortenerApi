/*
 * @#StatisticsDto.java - 2019
 * You can modify, use, reproduce or distribute this software.
 */
package com.example.demo.dto;

import java.io.Serializable;

/**
 * @author rrequena - Roberto Requena (rart3001@gmail.com)
 * @version 1.0
 * @since 20/01/19
 */
public class StatisticsDto implements Serializable{
	
	/**
	 * The Serial Version UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The total of shorted URL created
	 */
	private int totalCreated;
	
	/**
	 * The total of shorted URL accessed
	 */
	private int totalAccessed;

	/**
	 * Constructor
	 */
	public StatisticsDto() {
		super();
		this.totalCreated = 0;
		this.totalAccessed = 0;
	}

	/**
	 * Constructor with parameters
	 * @param totalCreated
	 * @param totalAccessed
	 */
	public StatisticsDto(int totalCreated, int totalAccessed) {
		super();
		this.totalCreated = totalCreated;
		this.totalAccessed = totalAccessed;
	}

	/**
	 * @return the totalCreated
	 */
	public int getTotalCreated() {
		return totalCreated;
	}

	/**
	 * @param totalCreated the totalCreated to set
	 */
	public void setTotalCreated(int totalCreated) {
		this.totalCreated = totalCreated;
	}

	/**
	 * @return the totalAccessed
	 */
	public int getTotalAccessed() {
		return totalAccessed;
	}

	/**
	 * @param totalAccessed the totalAccessed to set
	 */
	public void setTotalAccessed(int totalAccessed) {
		this.totalAccessed = totalAccessed;
	}

}
