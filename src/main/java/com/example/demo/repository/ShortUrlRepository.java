/*
 * @#ShortUrlRepository.java - 2019
 * You can modify, use, reproduce or distribute this software.
 */
package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ShortUrl;

/**
 * @author rrequena - Roberto Requena (rart3001@gmail.com)
 * @version 1.0
 * @since 20/01/19
 */
@Repository
@Transactional
public interface ShortUrlRepository extends JpaRepository<ShortUrl, String> {

	List<ShortUrl> findAllByCreated(Date created);

	List<ShortUrl> findAllByCreatedBetween(Date createdStart, Date createdEnd);

	List<ShortUrl> findAllByAccessed(Date accessed);

	List<ShortUrl> findAllByAccessedBetween(Date accessedStart, Date accessedEnd);
}
