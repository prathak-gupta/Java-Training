package com.onlinebookshop.shop.model;

public class Book {
	private int id, author_id;
	private String title;
	private double prize;
	public Book(int id, int author_id, String title, double prize) {
		super();
		this.id =id;
		this.author_id = author_id;
		this.title = title;
		this.prize = prize;
	}
	public Book( int author_id, String title, double prize) {
		super();

		this.author_id = author_id;
		this.title = title;
		this.prize = prize;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getPrize() {
		return prize;
	}
	public void setPrize(double prize) {
		this.prize = prize;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", author_id=" + author_id + ", title=" + title + ", prize=" + prize + "]";
	}
	
	
}
