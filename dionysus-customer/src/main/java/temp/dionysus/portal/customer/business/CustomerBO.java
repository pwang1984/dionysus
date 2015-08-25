package temp.dionysus.portal.customer.business;

import java.util.List;

import temp.dionysus.portal.customer.domain.Customer;
import temp.dionysus.portal.customer.exception.CustomerAlreadyExistsException;
import temp.dionysus.portal.customer.exception.CustomerCredentialException;

public interface CustomerBO {
	boolean register(Customer customer) throws CustomerAlreadyExistsException;

	void updateCustomer(Customer customer);

	Customer findCustomerByEmail(String email);

	List<Customer> getAllCustomers();

	Customer get(int customerId);

	Customer login(String email, String password) throws CustomerCredentialException;
}
