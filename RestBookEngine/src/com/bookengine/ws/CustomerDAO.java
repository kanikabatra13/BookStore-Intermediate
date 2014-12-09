package com.bookengine.ws;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

	private List<Customer> customers = new ArrayList<Customer>();

	public CustomerDAO() {

		Customer customer1 = new Customer("kanika", "Chicago", "312312312",
				"abc123","kanika","abcd123");
		Customer customer2 = new Customer("John Smith", "45 East Lake View, Chicago IL", "312-312-3127",
				"c11","john","abcd123");
		Customer customer3 = new Customer("Andy ", "Lincoln Park, Chicago IL", "312-890-4568",
				"c12","andy","abcd123");
		Customer customer4 = new Customer("Ross Taylor", "34 EdgeWater, Chicago IL", "312-890-789",
				"c23","ross","abcd123");

		customers.add(customer1);
		customers.add(customer2);
		customers.add(customer3);
		customers.add(customer4);

	}

	public List<Customer> getCustomers() {
		return customers;
	}
}