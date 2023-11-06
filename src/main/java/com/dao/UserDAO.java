package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.jaxb.mapping.NamedQuery;
import org.hibernate.query.CommonQueryContract;
import org.hibernate.query.Query;

import com.entity.UserInput;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class UserDAO {

	private SessionFactory factory = null;
	private Session session = null;
	private Transaction transaction = null;

	public UserDAO(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public boolean saveUser(UserInput user) {

		boolean f = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();

			session.persist(user);
			transaction.commit();

			f = true;
		} catch (Exception e) {
			if (transaction != null) {
				f = false;
				e.printStackTrace();
			}
		}

		return f;
	}

	public UserInput login(String email, String password) {

		UserInput user = null;

		session = factory.openSession();

		Query q = session.createQuery("from UserInput where email=:em and password=:pass");

		q.setParameter("em", email);
		q.setParameter("pass", password);

		user = (UserInput) q.uniqueResult();

		return user;
	}
}
