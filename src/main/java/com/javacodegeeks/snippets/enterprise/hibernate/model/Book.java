package com.javacodegeeks.snippets.enterprise.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {


	private Integer id;
	
	@Column(name = "title")
	private String title;
	
	@Column(name= "author")
	String author;
	
	public Book() {
	}

	public Book(Integer id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}
	
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
	@Id
	@GeneratedValue
	@Column(name = "id")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Book: " + this.id + ", " + this.title + ", " + this.author;
	}
	
}