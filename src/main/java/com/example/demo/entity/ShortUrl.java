/*
 * @#ShortUrl.java - 2019
 * You can modify, use, reproduce or distribute this software.
 */
package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 * @author rrequena - Roberto Requena (rart3001@gmail.com)
 * @version 1.0
 * @since 20/01/19
 */
@Entity
@Table(name = "short_urls")
public class ShortUrl implements Serializable {

	/**
	 * The serial version uid
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The represent the value of the id
	 */
	@Id
	@NotNull
    @Column(name="id")
    private String id;
	
	/**
	 * The represent the value of the originalUrl
	 */
	@NotNull
    @Column(name="original_url")
    private String originalUrl;
    
    /**
	 * The represent the value of the created
	 */
	@Temporal(TemporalType.DATE)
    @Column(name="created_date")
    private Date created;
    
    /**
	 * The represent the value of the accessed
	 */
	@Temporal(TemporalType.DATE)
    @Column(name="acessed_date")
    private Date accessed;

    /**
     * Constructor
     */
	public ShortUrl() {
		super();
		created = new Date(System.currentTimeMillis());
	}

	/**
	 * Constructor with parameters
	 * @param id
	 * @param originalUrl
	 * @param created
	 * @param accessed
	 */
	public ShortUrl(@NotNull String id, @NotNull String originalUrl, Date created, Date accessed) {
		super();
		this.id = id;
		this.originalUrl = originalUrl;
		this.created = created;
		this.accessed = accessed;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the originalUrl
	 */
	public String getOriginalUrl() {
		return originalUrl;
	}

	/**
	 * @param originalUrl the originalUrl to set
	 */
	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	/**
	 * @return the created
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 * @return the accessed
	 */
	public Date getAccessed() {
		return accessed;
	}

	/**
	 * @param accessed the accessed to set
	 */
	public void setAccessed(Date accessed) {
		this.accessed = accessed;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ShortUrl other = (ShortUrl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ShortUrl [id=" + id + ", originalUrl=" + originalUrl + ", created=" + created + ", accessed=" + accessed
				+ "]";
	}

}
