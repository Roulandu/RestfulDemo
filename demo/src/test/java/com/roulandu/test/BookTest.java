package com.roulandu.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.roulandu.entity.Book;
import com.roulandu.service.BookService;

public class BookTest {
	@Autowired
	private BookService bookService;

	/**
	 * ���before���������еĲ��Է���֮ǰִ�У�����ִֻ��һ�� ������Junit��Ԫ����ʱһЩ��ʼ��������������������������
	 * ������before���������ʼ��ApplicationContext��bookService
	 */
	@Before
	public void before() {
		// ʹ��"spring.xml"��"spring-mybatis.xml"�����������ļ�����Spring������
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "springmvc-config.xml", "spring-mybatis.xml" });
		// ��Spring�����и���bean��idȡ������Ҫʹ�õ�userService����
		bookService = (BookService) ac.getBean("bookService");
	}

	@Test
	public void testAddUser() {
		Book book = new Book();

		book = bookService.getBookById(1);

		System.out.println(book.getBookName());
	}
}
