package com.bookengine.ws;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class OrderDAO {

	private List<Order> orders = new ArrayList<Order>();


	public OrderDAO() {
//		order.setOrderID("567");
//		order.setBookID("3");
//		Set status = new HashSet();
//		status.add("Ordered");
//		order.setStatus(status);
		
		Customer customer1 = new Customer("John Smith", "45 East Lake View, Chicago IL", "312-312-3127",
				"c11","john","abcd123");
		Customer customer2 = new Customer("Andy ", "Lincoln Park, Chicago IL", "312-890-4568",
				"c12","andy","abcd123");
		Customer customer3 = new Customer("Ross Taylor", "34 EdgeWater, Chicago IL", "312-890-789",
				"c23","ross","abcd123");
		
		
		PaymentInfo paymentinfo1 = new PaymentInfo("AMEX","2345-7890-5678");
		PaymentInfo paymentinfo2 = new PaymentInfo("VISA","7890-6789-4567");
		
		Order order1 = new Order("546","X1","Shipped",customer1,paymentinfo1);
		Order order2= new Order("782","X2","Ordered",customer2,paymentinfo2);
		Order order3= new Order("389","X3","Processed",customer3,paymentinfo1);
		
		orders.add(order1);
		orders.add(order2);
		orders.add(order3);
		
	}
	

	public Order buyBooks(String bookId, Customer customer)
	{
		Order order = new Order();
		//Customer customer = new Customer(name, address,ph,custId);
		PaymentInfo paymentinfo = new PaymentInfo();
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		
	    String id = "" + randomInt;
	    order.setOrderID(id);
	    order.setBookID(bookId);
	    order.setCustomer(customer);
	    order.setPaymentinfo(paymentinfo);
	    order.setStatus("Ordered");		
		orders.add(order);
		return order;
	}

	public Order getOrder(String orderID) {
		for (Order order : orders) {
			if (order.getOrderID().equals(orderID))
				return order;
		}
		return null;
	}
	
	

	public String getOrderStatus(String orderID) {
		for (Order order : orders) {
			if (order.getOrderID().equals(orderID))
				return order.getStatus();
		}
		return null;
	}
	
	public String cancelOrder(String orderID){	
		for (Order order : orders) {
			if (order.getOrderID().equals(orderID))
			{   
				if(order.getStatus().equals("Shipped"))
				{
					//return "Your Order has been Shipped it cannot be cancelled";
					return null;
				}
				  
				else{
					
			        order.setStatus("Cancelled");
			        return "OK";
			       // return "Your Order has been cancelled";
				}
				
		     }
		}
			return null;
			}
	
	public String deleteOrder(String orderID) {
		int flag = 0;
		for (Order order : orders) {
			if (order.getOrderID().equals(orderID))
			{   
				orders.remove(order);
				flag = 1;
				
			}
		}
		if(flag == 1)
			return "OK";
		else
			return null;
		
	}
	
	public Customer getCustomerInfo(String orderID) {
		for (Order order : orders) {
			if (order.getOrderID().equals(orderID))
				return order.getCustomer();
		}
		return null;
	}
}

