package temp.dionysus.portal.customer.dao;

import java.util.List;

import temp.dionysus.portal.customer.domain.Customer;

public interface CustomerDAO {
	void addCustomer(Customer customer);

	Customer getCustomerByEmail(String email);

	void updateCustomer(Customer customer);

	List<Customer> getAllCustomers();

	Customer getCustomerById(int customerId);
}
