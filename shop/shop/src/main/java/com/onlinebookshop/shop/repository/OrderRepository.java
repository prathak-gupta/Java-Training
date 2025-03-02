package com.onlinebookshop.shop.repository;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.onlinebookshop.shop.model.Order;

@Repository
public class OrderRepository {
	
	private JdbcTemplate jdbcTemplate;

	public OrderRepository(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private RowMapper<Order> orderRowMapper = (rs, rNum)-> 
	new Order(rs.getInt("id"), rs.getInt("book_id"), rs.getInt("quantity"), rs.getDate("order_date"));
	
	
	// database CRUDE Operations
	// insert query
	public int save(Order order)
	{
		String q = "Insert into orders(book_id, quantity) values(?,?)";
		return jdbcTemplate.update(q,order.getBookId(),order.getQuantity());
	}
	
	
	// read -> get all orders data
	public List<Order> listOrders(){
		String query = "Select * from orders";
		return jdbcTemplate.query(query, orderRowMapper);
	}
	
	// find -> get order by id
	public Order findOrderById(int id)
	{
		String query = "Select * from orders where id="+id;
		return jdbcTemplate.queryForObject(query, orderRowMapper);
	}
	
	// update order
	public int updateOrder(int id, int qt)
	{
		String query ="Update orders SET quantity=? where id="+id;
		return jdbcTemplate.update(query, qt);		//it returns no of rows affected..
	}
	
	// delete Order
	public int deleteOrder(int id)
	{
		String query = "DELETE from orders where id=?";
		return jdbcTemplate.update(query, id);
	}

}
