package com.temp.dionysus.portal.customer.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.temp.dionysus.portal.customer.dao.CustomerDAO;
import com.temp.dionysus.portal.customer.domain.Customer;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCustomer(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
	}

	@Override
	public Customer getCustomerByEmail(String email) {
		return (Customer) sessionFactory
				.getCurrentSession()
				.createCriteria(Customer.class)
				.add(Restrictions.eq("email", email))
				.uniqueResult();
	}

	@Override
	public void updateCustomer(Customer customer) {
		sessionFactory.getCurrentSession().update(customer);
	}

	@Override
	public boolean customerExists(Customer customer) {
		return sessionFactory.getCurrentSession().get(Customer.class, customer.getCustomerId()) != null;
	}

}
