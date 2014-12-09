package com.bookengine.ws.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;

import com.bookengine.ws.Customer;
import com.bookengine.ws.service.representation.BookRepresentation;
import com.bookengine.ws.service.representation.OrderRepresentation;
import com.bookengine.ws.service.representation.OrderRequest;
import com.bookengine.ws.service.workflow.BookActivity;
import com.bookengine.ws.service.workflow.OrderActivity;

@CrossOriginResourceSharing(allowAllOrigins = true)

@Path("/orderservice")
public class OrderResource implements OrderService{

	/*@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	//@Produces({ "application/xml", "application/json" })
	//@Consumes({ "application/xml", "application/json" })
	@Path("/order/{bookId}")
	public OrderRepresentation addOrder(@PathParam("bookId") String bookID) {
		System.out.println("POST METHOD Request from Client with Book ID............." + bookID);
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.addOrder(bookID);
	}*/
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/customer")
	public Response customerAuth(@QueryParam("username") String username,
			@QueryParam("password") String password) {
		OrderActivity orderActivity = new OrderActivity();
		System.out
				.println("GET METHOD Request from Client with username & password .............");
		if (orderActivity.authenticate(username, password) == null) {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		return Response.status(Status.OK).build();
	}

	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	//@Produces({ "application/xml", "application/json" })
	//@Consumes({ "application/xml", "application/json" })
	@Path("/order")
	public OrderRepresentation addOrder(OrderRequest orderRequest) {
		System.out.println("POST METHOD Request from Client with Book ID............." + orderRequest.getBookId());
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.addOrder(orderRequest.getBookId(), orderRequest.getCustomer());
	}
	

	@GET
	@Produces({MediaType.APPLICATION_JSON })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/order/{orderId}")
	public OrderRepresentation getOrder(@PathParam("orderId") String orderID) {
		System.out.println("\nGET METHOD Request from Client to get Order Status of Order ID............."
						+ orderID);
		OrderActivity orderActivity = new OrderActivity();
		return orderActivity.getOrder(orderID);
		
	}
	
	@PUT
	@Produces({ MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/order/{orderId}")
	public Response cancelOrder(@PathParam("orderId") String orderID) {
		System.out.println("\nPUT METHOD Request from Client to cancel the order ............."
						+ orderID);
		OrderActivity orderActivity = new OrderActivity();
		if (orderActivity.cancelOrder(orderID) == null) {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		return Response.status(Status.OK).build();
		//return orderActivity.cancelOrder(orderID);
		
	}

	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("/{orderId}")
	public Response deleteOrder(@PathParam("orderId")String orderID) {
		
		System.out.println("\nDelete METHOD Request from Client to delete Order orderId............." + orderID);
		OrderActivity ordActivity = new OrderActivity();
		//String res = ordActivity.deleteOrder(orderID);
		if (ordActivity.deleteOrder(orderID) == null) {
			return Response.status(Status.UNAUTHORIZED).build();
		}
		return Response.status(Status.OK).build();
		/*if (res.equals("OK")) {
			return Response.status(Status.OK).build();
		}
		
		return null;*/
			}
		
		
	


	
	
	
	
}
