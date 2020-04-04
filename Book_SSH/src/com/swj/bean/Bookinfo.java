package com.swj.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Bookinfo entity. @author MyEclipse Persistence Tools
 */

public class Bookinfo implements java.io.Serializable {

	// Fields

	// private BigDecimal bookid;
	private String bookid;
	private String title;
	private String author;
	private Double price;
	private Date pubdate;

	// Constructors

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	/** default constructor */
	public Bookinfo() {
	}

	/** full constructor */
	public Bookinfo(String title, String author, Double price, Date pubdate) {
		this.title = title;
		this.author = author;
		this.price = price;
		this.pubdate = pubdate;
	}

	// Property accessors

	/*
	 * public BigDecimal getBookid() { return this.bookid; }
	 * 
	 * public void setBookid(BigDecimal bookid) { this.bookid = bookid; }
	 */

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getPubdate() {
		return this.pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	@Override
	public String toString() {
		return "Bookinfo [bookid=" + bookid + ", title=" + title + ", author="
				+ author + ", price=" + price + ", pubdate=" + pubdate + "]";
	}

}