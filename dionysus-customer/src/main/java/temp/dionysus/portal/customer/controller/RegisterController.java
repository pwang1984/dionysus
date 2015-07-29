package temp.dionysus.portal.customer.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import temp.dionysus.portal.customer.dao.CustomerDAO;
import temp.dionysus.portal.customer.domain.Customer;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	CustomerDAO customerDAO;

	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {

		return "registration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") Customer customer, Map<String, Object> model) {
		customerDAO.addCustomer(customer);

		return "registrationSuccess";
	}
}
