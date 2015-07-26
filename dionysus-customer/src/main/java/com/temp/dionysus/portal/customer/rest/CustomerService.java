package com.temp.dionysus.portal.customer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.temp.dionysus.portal.customer.dao.CustomerDAO;
import com.temp.dionysus.portal.customer.domain.Customer;

@RestController
public class CustomerService {
	@Autowired
	CustomerDAO customerDAO;

	@RequestMapping("/customer/login")
	public Customer login(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) {
		return customerDAO.getCustomerByEmail(email);
	}

	@RequestMapping(value = "/customer/register", method = RequestMethod.POST)
	public void register(Customer customer) {
		customerDAO.updateCustomer(customer);
	}

}
