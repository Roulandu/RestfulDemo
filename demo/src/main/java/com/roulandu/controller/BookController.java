package com.roulandu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.roulandu.entity.Book;
import com.roulandu.service.BookService;

@Controller
@RequestMapping(value = "/book")
public class BookController {
	@Autowired
	private BookService bookService;

	@RequestMapping(value = "/getBook/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Book getBook(@PathVariable int id) {
		Book book = this.bookService.getBookById(id);
		return book;
	}

	@RequestMapping(value = "/getBooks", method = RequestMethod.GET)
	@ResponseBody
	public List<Book> getBooks() {
		List<Book> book = this.bookService.getBooks();
		return book;
	}

	@RequestMapping(value = "/addBook", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public int addBook(@RequestBody Book book) {
		return this.bookService.insertBook(book);
	}

	@RequestMapping(value = "/updateBook/{id}", method = RequestMethod.PUT, produces = "application/json")
	@ResponseBody
	public int updateBook(@PathVariable int id, @RequestBody Book book) {
		Book b = this.bookService.getBookById(id);
		b.setBookName(book.getBookName());
		b.setBookAuthor(book.getBookAuthor());
		b.setBookPress(book.getBookPress());
		b.setBookPrice(book.getBookPrice());
		return this.bookService.updateBook(b);
	}

	@RequestMapping(value = "/deleteBook/{id}", method = RequestMethod.DELETE, produces = "application/json")
	@ResponseBody
	public int deleteBook(@PathVariable int id) {
		return this.bookService.deleteBook(id);
	}
}
