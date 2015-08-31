package temp.dionysus.portal.customer.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import temp.dionysus.portal.customer.dao.CustomerDAO;
import temp.dionysus.portal.customer.domain.Customer;
import temp.dionysus.portal.customer.exception.CustomerCredentialException;
import temp.dionysus.mailservice.*;

@RestController
public class CustomerService {
	@Autowired
	CustomerDAO customerDAO;
	
	@Autowired
	MailService mailService;

	@RequestMapping(value = "rest/customer/login", method = RequestMethod.POST)
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
		// send confirmation email
		mailService.sendMail("no_reply@volantesystems.com",
	       		   customer.getEmail(),
	       		   "Thank you for registration", 
	       		   "Thank you for registering with dionysusu");
	}
	
	@RequestMapping(value = "internal/customer/list", method = RequestMethod.GET)
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}
	
	@RequestMapping(value="internal/customer/get/{customerId}", method=RequestMethod.GET)
	@ResponseBody
	public Customer getCustomerById(@PathVariable("customerId") int id) {
		return customerDAO.getCustomerById(id);
	}
}
