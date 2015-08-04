package temp.dionysus.portal.customer.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import temp.dionysus.portal.customer.dao.CustomerDAO;
import temp.dionysus.portal.customer.domain.Customer;
import temp.dionysus.portal.customer.exception.CustomerCredentialException;

@RestController
public class CustomerService {
	@Autowired
	CustomerDAO customerDAO;

	@RequestMapping("rest/customer/login")
	public Customer login(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password) throws CustomerCredentialException {
		Customer customer = customerDAO.getCustomerByEmail(email);
		if (customer == null || !customer.getPassword().equals(password)) {
			throw new CustomerCredentialException();
		}
		return customer;
	}

	@RequestMapping(value = "rest/customer/register", method = RequestMethod.POST)
	public void register(Customer customer) {
		customerDAO.addCustomer(customer);
	}
}
