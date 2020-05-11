package com.book.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.exception.BookNotFoundException;
import com.book.model.Book;
import com.book.repository.BooksRepository;

@Service
public class BooksService {
	@Autowired
	BooksRepository booksRepository;

	public Iterable<Book> getAllBooks() {
		//List<Book> books = new ArrayList<Book>();
		//booksRepository.findAll().forEach(books1 -> books.add(books1));
		return booksRepository.findAll();
	}

	public Book getBooksById(int id) {

		Book book = null;
		try {
			book = booksRepository.findById(id).get();
		} catch (Exception e) {
			throw new BookNotFoundException("Book Not Found : " + id);
		}
		return book;
	}
	
	public Book getBooksByBookName(String bookName) {

		Book book = null;
		try {
			//book = booksRepository.findbookByBookName(bookName);
		} catch (Exception e) {
			throw new BookNotFoundException("Book Not Found : " + bookName);
		}
		return book;
	}

	public void saveOrUpdate(Book books) {
		booksRepository.save(books);
	}

	public void delete(int id) {
		booksRepository.deleteById(id);
	}

	public void update(Book books, int bookid) {
		booksRepository.save(books);
	}
}