package com.onlinebookshop.shop.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.onlinebookshop.shop.model.Author;

@Repository
public class AuthorRepository {
	private final JdbcTemplate jdbcTemplate;

	public AuthorRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	// Create Row Mapper for Author Class..
	private RowMapper<Author> authRowMapper= (rs, rowNum)->new Author(rs.getInt("id"), rs.getString("name"), rs.getString("country"));
	
	// CRUD Operations
	
	// create -> insert Query
	public int save(Author auth)
	{
		String query = "INSERT into authors(name, country) Values(?,?)";
		return jdbcTemplate.update(query, auth.getName(), auth.getCountry());
	}
	
	// read -> get all authors
	public List<Author> listAuthors(){
		String query = "Select * from authors";
		return jdbcTemplate.query(query, authRowMapper);
	}
	
	// find -> get auhtor by id
	public Author findAuthorById(int id)
	{
		String query = "Select * from authors where id="+id;
		return jdbcTemplate.queryForObject(query, authRowMapper);
	}
	
	// update author
	public int updateAuthor(int id, String newName)
	{
		String query ="Update authors SET name=? where id="+id;
		return jdbcTemplate.update(query, newName);		//it returns no of rows affected..
	}
	
	// delete author
	public int deleteAuthor(int id)
	{
		String query = "DELETE from authors where id=?";
		return jdbcTemplate.update(query, id);
	}
}
