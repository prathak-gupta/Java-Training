package com.onlinebookshop.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.onlinebookshop.shop.model.Author;
import com.onlinebookshop.shop.model.Book;
import com.onlinebookshop.shop.repository.BookRepository;

@Service
public class BookService {
	
	private BookRepository bookRp;

	public BookService(BookRepository book) {
		super();
		this.bookRp = book;
	}
	
	//add new book
	public void addBook(Book book)
	{
		bookRp.save(book);		
	}
	
	//fetch all books
	public List<Book> getAllBooks()
	{
		return bookRp.listBooks();
	}
	
	//fetch by id
	public Book getBookById(int id)
	{
		return bookRp.findBookById(id);
	}
	
	//update book by id
	public int updatebook(Book book)
	{
		return bookRp.updateBook(book);
	}
	
	//delete authors service
	public int deleteBook(int id)
	{
		return bookRp.deleteBook(id);
	}
	

}
