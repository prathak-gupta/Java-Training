package com.onlinebookshop.shop.model;

import java.util.Date;

public class Order {
	private int id, bookId, quantity;
	private Date order_date;
	public Order(int id, int bookId, int quantity, Date date) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.quantity = quantity;
		this.order_date = date;
	}

	public Order( int bookId, int quantity) {
		super();

		this.bookId = bookId;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getDate() {
		return order_date;
	}
	public void setDate(Date date) {
		this.order_date = date;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", bookId=" + bookId + ", quantity=" + quantity + ", date=" + order_date + "]";
	}
	
	
}
