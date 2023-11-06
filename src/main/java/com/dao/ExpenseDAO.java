package com.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.entity.Expense;
import com.entity.UserInput;

public class ExpenseDAO {

	private SessionFactory factory = null;
	private Session session = null;
	private Transaction transaction = null;

	public ExpenseDAO(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	public boolean saveExpense(Expense ex) {

		boolean f = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.persist(ex);
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

	public List<Expense> getAllExpenseByUser(UserInput user) {

		List<Expense> list = new ArrayList<Expense>();

		try {
			session = factory.openSession();
			Query q = session.createQuery("from Expense where user=:us");
			q.setParameter("us", user);
			list = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public Expense getExpenseById(int id) {
		
		Expense ex = null;
		
		try {
			session = factory.openSession();
			Query q = session.createQuery("from Expense where id=:id");
			
			q.setParameter("id",id);
			ex = (Expense) q.uniqueResult();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return ex;
	}
	
	public boolean updateExpense(Expense ex) {

		boolean f = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(ex);
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
	
	public boolean deleteExpense(int id) {

		boolean f = false;

		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			
			Expense ex = session.get(Expense.class, id);
			
			session.delete(ex);
			
			transaction.commit();
			f = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}
}
