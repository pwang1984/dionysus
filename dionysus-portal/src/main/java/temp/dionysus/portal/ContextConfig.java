package temp.dionysus.portal;

import java.sql.Connection;
import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import temp.dionysus.portal.customer.business.CustomerBO;
import temp.dionysus.portal.customer.business.impl.CustomerBOImpl;
import temp.dionysus.portal.customer.dao.CustomerDAO;
import temp.dionysus.portal.customer.dao.impl.CustomerDAOImpl;

@Configuration
public class ContextConfig {
	/**
	 * Default timeout when connect in ms
	 */
	private static final int DEFAULT_MAX_WAIT = 5000;

	/**
	 * Default timeout for abandoned connection (not properly closed connection) in seconds
	 */
	private static final int DEFAULT_REMOVE_ABANDONED_TIME_OUT = 600;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactory.setDataSource(dataSource());
		entityManagerFactory.setPackagesToScan("temp.dionysus.portal.customer.domain");
		//		sessionBuilder.addAnnotatedClasses(User.class);
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		entityManagerFactory.setJpaVendorAdapter(vendorAdapter);
		entityManagerFactory.setJpaProperties(additionalProperties());
		return entityManagerFactory;
	}

	@Inject
	@Bean
	public SessionFactory sessionFactory(DataSource dataSource) {
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.scanPackages("temp.dionysus.portal.customer.domain");
		sessionBuilder.setProperty("hibernate.show_sql", "true");
		sessionBuilder.setProperty("hibernate.format_sql", "true");
		sessionBuilder.setProperty("hibernate.hbm2ddl.auto", "update");
		//		sessionBuilder.addAnnotatedClasses(User.class);

		return sessionBuilder.buildSessionFactory();
	}

	private Properties additionalProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		return properties;
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

	@Bean
	public Logger logger() {
		return Logger.getLogger("dionysus");
	}

	@Bean
	public CustomerBO customerBO() {
		return new CustomerBOImpl();
	}

}
