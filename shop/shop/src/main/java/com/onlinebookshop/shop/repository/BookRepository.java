package com.onlinebookshop.shop.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.onlinebookshop.shop.model.Author;
import com.onlinebookshop.shop.model.Book;

@Repository
public class BookRepository {
	
	private JdbcTemplate jdbcTemplate;

	public BookRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private RowMapper<Book> bookRowMapper = (rs, rwoNum)-> new Book( rs.getInt("id"),rs.getInt("author_id"), rs.getString("title"), rs.getDouble("price"));

	
	// database CRUDE Operations
	// insert query
	public int save(Book book)
	{
		String q = "Insert into books(title, author_id, price) values(?,?,?)";
		return jdbcTemplate.update(q, book.getTitle(),book.getAuthor_id(),book.getPrize());
	}
	
	
	// read -> get all books data
	public List<Book> listBooks(){
		String query = "Select * from books";
		return jdbcTemplate.query(query, bookRowMapper);
	}
	
	// find -> get book by id
	public Book findBookById(int id)
	{
		String query = "Select * from books where id="+id;
		return jdbcTemplate.queryForObject(query, bookRowMapper);
	}
	
	// update book
	public int updateBook(Book book) {
        String sql = "UPDATE books SET title = ?, price = ?, author_id = ? WHERE id = ?";
        return jdbcTemplate.update(sql, book.getTitle(), book.getPrize(), book.getAuthor_id(), book.getId());
    }
	// delete book
	public int deleteBook(int id)
	{
		String query = "DELETE from books where id=?";
		return jdbcTemplate.update(query, id);
	}

	
	
}
