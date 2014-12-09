package com.bookengine.ws.service.workflow;

import com.bookengine.ws.Customer;
import com.bookengine.ws.CustomerDAO;
import com.bookengine.ws.Link;
import com.bookengine.ws.Order;
import com.bookengine.ws.OrderDAO;
import com.bookengine.ws.service.representation.BookRepresentation;
import com.bookengine.ws.service.representation.OrderRepresentation;


public class OrderActivity {
	
	private static final String String = null;
	private static OrderDAO orderdao = new OrderDAO();
	private static CustomerDAO customerDao = new CustomerDAO();
	
	public OrderRepresentation addOrder(String bookId, Customer customer )
	{
	
        Order order = orderdao.buyBooks(bookId,customer);
       

		OrderRepresentation orderRep = new OrderRepresentation();
		orderRep.setBookID(order.getBookID());
		orderRep.setOrderID(order.getOrderID());
		orderRep.setCustomer(order.getCustomer());
		orderRep.setPaymentinfo(order.getPaymentinfo());
		orderRep.setStatus(order.getStatus());
		
		setLinks(orderRep);
		return orderRep;
	}
	
	public OrderRepresentation getOrder(String orderID)
	{
	
        Order order = orderdao.getOrder(orderID);
		
		OrderRepresentation orderRep = new OrderRepresentation();
		orderRep.setBookID(order.getBookID());
		orderRep.setOrderID(order.getOrderID());
		orderRep.setCustomer(order.getCustomer());
		orderRep.setPaymentinfo(order.getPaymentinfo());
		orderRep.setStatus(order.getStatus());
		return orderRep;
	}
	
	
	public String cancelOrder(String orderID)
	{
	
        String response = orderdao.cancelOrder(orderID);
        System.out.println(response);
		
		return response;
		
	}
	public String deleteOrder(String orderID)
	{
	
        String response = orderdao.deleteOrder(orderID);
		return response;
	}
	public String authenticate(String username, String password) {
		for (Customer customer : customerDao.getCustomers()) {
			if (customer.getUsername().equals(username)
					&& customer.getPassword().equals(password)) {
				return customer.getCustId();
			}
		}
		return null;
	}
	
	private void setLinks(OrderRepresentation orderRep) {
		// Set up the activities that can be performed on orders
		Link status = new Link("status", "http://54.88.78.26/ws/orderservice/order/" + orderRep.getOrderID());
		Link cancel = new Link("cancel", "http://54.88.78.26/ws/orderservice/order/" + orderRep.getOrderID());
		
		orderRep.setLinks(status,cancel);
		//orderRep.setLinks(cancel);
	}
	

}
