package com.temp.dionysus.portal.customer.dao;

import com.temp.dionysus.portal.customer.domain.Customer;

public interface CustomerDAO {
	void addCustomer(Customer customer);

	Customer getCustomerByEmail(String email);

	void updateCustomer(Customer customer);
}
