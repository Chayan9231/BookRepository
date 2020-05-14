package com.book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "Book")
@Getter @Setter
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private int bookid;
	@Column
	private String bookname;
	@Column
	private String author;
	@Column
	private int price;

	
}