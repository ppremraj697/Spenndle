package com.servlet;

import java.io.IOException;

import com.dao.ExpenseDAO;
import com.db.HibernateUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/deleteExpense")
public class DeleteExpenseServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		
		ExpenseDAO dao = new ExpenseDAO(HibernateUtil.getSessionFactory());
		boolean f = dao.deleteExpense(id);
		
		HttpSession session = req.getSession();
		
		if(f) {
			session.setAttribute("msg", "Expense Deleted Successfully");
			resp.sendRedirect("user/viewExpense.jsp");
		}
		else {
			session.setAttribute("msg", "Something went wrong on Server");
			resp.sendRedirect("user/viewExpense.jsp");
		}
	}

}
