package temp.dionysus.portal.customer.controller;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import temp.dionysus.portal.customer.business.CustomerBO;
import temp.dionysus.portal.customer.domain.Customer;
import temp.dionysus.portal.customer.exception.CustomerAlreadyExistsException;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Inject
	CustomerBO customerBO;

	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		return "registration";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("userForm") Customer customer, Map<String, Object> model) throws CustomerAlreadyExistsException {
		customerBO.register(customer);

		return "registrationSuccess";
	}
}
