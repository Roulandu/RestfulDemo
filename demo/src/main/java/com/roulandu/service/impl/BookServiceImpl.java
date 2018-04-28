package com.roulandu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.roulandu.dao.BookMapper;
import com.roulandu.entity.Book;
import com.roulandu.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookMapper bookMapper;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS)
	public Book getBookById(Integer id) {
		// TODO Auto-generated method stub
		return bookMapper.selectByPrimaryKey(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int insertBook(Book book) {
		// TODO Auto-generated method stub
		return bookMapper.insert(book);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int updateBook(Book book) {
		// TODO Auto-generated method stub
		return bookMapper.updateByPrimaryKey(book);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteBook(Integer id) {
		// TODO Auto-generated method stub
		return bookMapper.deleteByPrimaryKey(id);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return bookMapper.selectAll();
	}

}
