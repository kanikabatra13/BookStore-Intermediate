package com.bookengine.ws.service.workflow;

import com.bookengine.ws.Customer;
import com.bookengine.ws.CustomerDAO;
import com.bookengine.ws.Order;
import com.bookengine.ws.OrderDAO;
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
		
		
		return orderRep;
	}
	
	public String getOrderStatus(String orderID)
	{
	
        String status = orderdao.getOrderStatus(orderID);
		
		/*OrderRepresentation orderRep = new OrderRepresentation();
		orderRep.setBookID(order.getBookID());
		orderRep.setOrderID(order.getOrderID());
		orderRep.setCustomer(order.getCustomer());
		orderRep.setPaymentinfo(order.getPaymentinfo());
		orderRep.setStatus(order.getStatus());
		*/
		
		return status;
	}
	
	
	public String cancelOrder(String orderID)
	{
	
        String response = orderdao.cancelOrder(orderID);
		
		return response;
	}
	public String deleteOrder(String orderID)
	{
	
        String response = orderdao.deleteOrder(orderID);
		
			
		return response;
	}
	public String authenticate(String username, String password) {
		for (Customer customer : customerDao.getCustomers()) {
			if (customer.getName().equals(username)
					&& customer.getPhone().equals(password)) {
				return customer.getCustId();
			}
		}
		return null;
	}
	

}
