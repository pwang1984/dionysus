package temp.dionysus.portal.customer.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import temp.dionysus.portal.customer.dao.CustomerDAO;
import temp.dionysus.portal.customer.domain.Customer;

@Named
@Transactional
public class CustomerDAOImpl implements CustomerDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void addCustomer(Customer customer) {
		entityManager.persist(customer);
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		List<Customer> result = entityManager.createQuery("select c from Customer c where email = :email", Customer.class)
				.setParameter("email", email)
				.getResultList();
		return (result.isEmpty() ? null : result.get(0));
	}

	@Override
	public void updateCustomer(Customer customer) {
		entityManager.persist(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> resultList = entityManager.createQuery("Select c from Customer c", Customer.class).getResultList();
		return resultList;
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return entityManager.find(Customer.class, customerId);
		//		return entityManager.createQuery("select c from Customer c where customerId = :customerId", Customer.class).setParameter("customerId", customerId).getSingleResult();
	}

}
