package com.onlinebookshop.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinebookshop.shop.model.Order;
import com.onlinebookshop.shop.repository.OrderRepository;


@Service
public class OrderService {
	OrderRepository orderRp;

	public OrderService(OrderRepository orp) {
		super();
		this.orderRp = orp;
	}
	
	public int addOrder(Order order)
	{
		return orderRp.save(order);		
	}
	
	public List<Order> getAllOrders()
	{
		return orderRp.listOrders();
	}
	
	public Order getOrderById(int id)
	{
		return orderRp.findOrderById(id);
	}
	
	public int updateOrder(int id, int qty)
	{
		return orderRp.updateOrder(id, qty);
	}
	
	public int deleteOrder(int id)
	{
		return orderRp.deleteOrder(id);
	}

}
