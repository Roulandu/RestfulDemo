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
	 * 这个before方法在所有的测试方法之前执行，并且只执行一次 所有做Junit单元测试时一些初始化工作可以在这个方法里面进行
	 * 比如在before方法里面初始化ApplicationContext和bookService
	 */
	@Before
	public void before() {
		// 使用"spring.xml"和"spring-mybatis.xml"这两个配置文件创建Spring上下文
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				new String[] { "springmvc-config.xml", "spring-mybatis.xml" });
		// 从Spring容器中根据bean的id取出我们要使用的userService对象
		bookService = (BookService) ac.getBean("bookService");
	}

	@Test
	public void testAddUser() {
		Book book = new Book();

		book = bookService.getBookById(1);

		System.out.println(book.getBookName());
	}
}
