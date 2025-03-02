package com.onlinebookshop.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.onlinebookshop.shop.model.Author;
import com.onlinebookshop.shop.model.Book;
import com.onlinebookshop.shop.model.Order;

@Configuration
public class AppConfig {
	
	@Bean
	public Author author1()
	{
		return new Author("Ram@Bean", "India");
	}
	
	@Bean
	public Author author2()
	{
		return new Author("Shyam@Bean", "India");		
	}
	
	@Bean
	public Book book1()
	{
		return new Book(1, "Atomic Habits@Bean", 750.00);
	}

	@Bean
	public Book book2()
	{
		return new Book(2, "JABC New Edition@Bean", 550.00);
	}
	
	@Bean
	public Order order1()
	{
		return new Order(5,33);
	}

	@Bean
	public Order order2()
	{
		return new Order(4,44);
	}
}
