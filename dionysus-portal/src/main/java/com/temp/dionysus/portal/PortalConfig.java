package com.temp.dionysus.portal;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

import com.temp.dionysus.portal.customer.dao.CustomerDAO;
import com.temp.dionysus.portal.customer.dao.impl.CustomerDAOImpl;

@Configuration
public class PortalConfig {
	/**
	 * Default timeout when connect in ms
	 */
	private static final int DEFAULT_MAX_WAIT = 5000;

	/**
	 * Default timeout for abandoned connection (not properly closed connection) in seconds
	 */
	private static final int DEFAULT_REMOVE_ABANDONED_TIME_OUT = 600;

	@Autowired
	@Bean
	public SessionFactory sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.scanPackages("com.temp.dionysus.portal.customer.domain");
		sessionBuilder.setProperty("hibernate.show_sql", "true");
		//		sessionBuilder.addAnnotatedClasses(User.class);

		return sessionBuilder.buildSessionFactory();
	}

	@Bean
	public DataSource dataSource() {
		//TODO: USE XML CONFIG
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("7890uiop");
		dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/dionysus");
		dataSource.setMinIdle(1);
		dataSource.setMaxIdle(8);
		dataSource.setMaxOpenPreparedStatements(200);
		dataSource.setMaxActive(-1);
		dataSource.setDefaultAutoCommit(true);
		dataSource.setDefaultTransactionIsolation(Connection.TRANSACTION_READ_UNCOMMITTED);
		dataSource.setMaxWait(DEFAULT_MAX_WAIT);
		dataSource.setValidationQuery("select 1");
		dataSource.setTestOnBorrow(true);
		dataSource.setValidationQueryTimeout(5);
		dataSource.setRemoveAbandoned(true);
		dataSource.setRemoveAbandonedTimeout(DEFAULT_REMOVE_ABANDONED_TIME_OUT);
		return dataSource;
	}

	@Bean
	public CustomerDAO customerDAO() {
		return new CustomerDAOImpl();
	}

}
