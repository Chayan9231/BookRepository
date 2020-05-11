package com.book.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.book.model.Book;

public interface BooksRepository extends CrudRepository<Book, Integer> {
	
	@Query("SELECT book FROM Book book WHERE book.bookname = ?1")
	 Book findbookByBookName(String name);
	
	@Query("SELECT book FROM Book book WHERE book.author = ?1")
	 Book findbookByAuthor(String authorName);
}
