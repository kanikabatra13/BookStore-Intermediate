package com.bookengine.ws.service;

import javax.jws.WebService;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status; 

import com.bookengine.ws.Customer;
import com.bookengine.ws.Order;
import com.bookengine.ws.service.representation.OrderRepresentation;
import com.bookengine.ws.service.representation.OrderRequest;

@WebService
public interface OrderService {

	public OrderRepresentation addOrder(OrderRequest orderrequest);
	public OrderRepresentation getOrder(String orderID);
	public Response cancelOrder(String orderID);
	public Response deleteOrder(String orderID);
}
