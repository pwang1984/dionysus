package temp.dionysus.portal.customer.business.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import temp.dionysus.portal.customer.business.CustomerBO;
import temp.dionysus.portal.customer.dao.CustomerDAO;
import temp.dionysus.portal.customer.domain.Customer;
import temp.dionysus.portal.customer.exception.CustomerAlreadyExistsException;
import temp.dionysus.portal.customer.exception.CustomerCredentialException;

public class CustomerBOImpl implements CustomerBO {
	@Inject
	private CustomerDAO customerDAO;

	@Override
	public boolean register(Customer customer) throws CustomerAlreadyExistsException {
		if (customerDAO.getCustomerByEmail(customer.getEmail()) != null) {
			throw new CustomerAlreadyExistsException();
		}
		customerDAO.addCustomer(customer);
		return true;
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDAO.updateCustomer(customer);
	}

	@Override
	public Customer findCustomerByEmail(String email) {
		return customerDAO.getCustomerByEmail(email);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	@Override
	public Customer get(int customerId) {
		return customerDAO.getCustomerById(customerId);
	}

	@Override
	public Customer login(String email, String password) throws CustomerCredentialException {
		Customer customer = customerDAO.getCustomerByEmail(email);
		if (customer == null || !customer.getPassword().equals(password)) {
			throw new CustomerCredentialException();
		}
		customer.setLastLoginTime(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		return customer;
	}

}
