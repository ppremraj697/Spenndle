package com.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.entity.Expense;
import com.entity.UserInput;


public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {			
			Configuration configuration = new Configuration();
			
			configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
			configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/ExpenseTrackerDB");
			configuration.setProperty("hibernate.connection.username", "root");
			configuration.setProperty("hibernate.connection.password", "Premraj@123");
			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			configuration.setProperty("hibernate.hbm2ddl.auto", "update");
			configuration.setProperty("hibernate.show.sql", "true");
			
			
			configuration.addAnnotatedClass(UserInput.class);
			configuration.addAnnotatedClass(Expense.class);
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		return sessionFactory;
	}

}
