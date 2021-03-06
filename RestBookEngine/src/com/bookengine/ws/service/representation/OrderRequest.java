package com.bookengine.ws.service.representation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.bookengine.ws.Customer;
import com.bookengine.ws.PaymentInfo;



@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRequest {

	private String orderId;
	private String bookId;
	private String status;
	private Customer customer;
	private PaymentInfo paymentinfo;

	public OrderRequest() {

	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public Customer getCustomer() {
		return customer;
	}
	
	

	public void setCustomer(Customer customer) {
		
		this.customer = customer;
	}

	public void setCustomer(CustomerRequest customerRequest) {
		Customer customer2 = new Customer();
		customer2.setCustId(customerRequest.getCustId());
		customer2.setAddress(customerRequest.getAddress());
		customer2.setName(customerRequest.getName());
		customer2.setPhone(customerRequest.getPhone());
		customer2.setUsername(customerRequest.getUsername());
		customer2.setPassword(customerRequest.getPassword());

		this.customer = customer2;
	}
	public PaymentInfo getPaymentinfo() {
		return paymentinfo;
	}

	public void setPaymentinfo(PaymentInfo paymentinfo) {
		this.paymentinfo = paymentinfo;
	}

	 public void setPaymentInfo(PaymentInfoRequest paymentInfoRequest)
	
	 {
		 PaymentInfo paymentinfo2 = new PaymentInfo();
		 paymentinfo2.setCardNumber(paymentInfoRequest.getCardNumber());
		 paymentinfo2.setCardType(paymentInfoRequest.getCardType());
		 
		 this.paymentinfo = paymentinfo2;
	 }
	 
	 
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	
	public String getBookId() {
		return bookId;
	}

	

}
