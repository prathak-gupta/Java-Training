package com.onlinebookshop.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinebookshop.shop.model.Author;
import com.onlinebookshop.shop.repository.AuthorRepository;

@Service
public class AuthorService {
	private AuthorRepository arp;

	public AuthorService(AuthorRepository arp) {
		this.arp = arp;
	}
	
	//add new author
	public void addAuthor(Author newAuthor)
	{
		arp.save(newAuthor);		
	}
	
	//fetch all authors
	public List<Author> getAllAuthors()
	{
		return arp.listAuthors();
	}
	
	//fetch by id
	public Author getAuthById(int id)
	{
		return arp.findAuthorById(id);
	}
	
	//update authors by id
	public int updateAuthor(int id, String name)
	{
		return arp.updateAuthor(id, name);
	}
	
	//delete authors service
	public int deleteAuth(int id)
	{
		return arp.deleteAuthor(id);
	}

}
