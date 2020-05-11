package com.book.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.exception.BookNotFoundException;
import com.book.model.Books;
import com.book.repository.BooksRepository;

@Service
public class BooksService {
	@Autowired
	BooksRepository booksRepository;

	public List<Books> getAllBooks() {
		List<Books> books = new ArrayList<Books>();
		booksRepository.findAll().forEach(books1 -> books.add(books1));
		return books;
	}

	public Books getBooksById(int id) {

		Books book = null;
		try {
			book = booksRepository.findById(id).get();
		} catch (Exception e) {
			throw new BookNotFoundException("Book Not Found : " + id);
		}
		return book;
	}

	public void saveOrUpdate(Books books) {
		booksRepository.save(books);
	}

	public void delete(int id) {
		booksRepository.deleteById(id);
	}

	public void update(Books books, int bookid) {
		booksRepository.save(books);
	}
}