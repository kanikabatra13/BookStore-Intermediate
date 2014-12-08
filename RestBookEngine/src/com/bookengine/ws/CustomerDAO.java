package com.bookengine.ws;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

	private List<Customer> customers = new ArrayList<Customer>();

	public CustomerDAO() {

		Customer customer1 = new Customer("kanika", "Chicago", "312312312",
				"abc123");

		customers.add(customer1);

	}

	public List<Customer> getCustomers() {
		return customers;
	}
}