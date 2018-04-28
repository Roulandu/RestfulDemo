package com.roulandu.service;

import java.util.List;

import com.roulandu.entity.Book;

public interface BookService {
	public Book getBookById(Integer id);

	public int insertBook(Book book);

	public int updateBook(Book book);

	public int deleteBook(Integer id);
	
	public List<Book> getBooks();
}
