package temp.dionysus.portal.customer.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import temp.dionysus.portal.customer.dao.CustomerDAO;
import temp.dionysus.portal.customer.domain.Customer;

@Repository
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
		return entityManager.createQuery("select * from Customers where email = :email", Customer.class).setParameter(":email", email).getSingleResult();
	}

	@Override
	public void updateCustomer(Customer customer) {
		entityManager.persist(customer);
	}

	@Override
	public boolean customerExists(Customer customer) {
		return entityManager.find(Customer.class, customer.getCustomerId()) != null;
	}

}
