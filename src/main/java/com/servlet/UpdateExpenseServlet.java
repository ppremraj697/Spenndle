package com.servlet;

import java.io.IOException;

import com.dao.ExpenseDAO;
import com.db.HibernateUtil;
import com.entity.Expense;
import com.entity.UserInput;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/updateExpense")
public class UpdateExpenseServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String title =req.getParameter("title");
		String date =req.getParameter("date");
		String description =req.getParameter("description");
		String amount =req.getParameter("amount");
		
		HttpSession session = req.getSession();
		UserInput user = (UserInput)session.getAttribute("loginUser");
		
				
		
		
		Expense ex = new Expense(title, date, description, amount, user);
		ex.setId(id);
		
		ExpenseDAO dao = new ExpenseDAO(HibernateUtil.getSessionFactory());
		boolean f = dao.updateExpense(ex);
		
		if (f) {
			session.setAttribute("msg", "Expense updated Successfully");
			resp.sendRedirect("user/viewExpense.jsp");
		} else {
			session.setAttribute("msg", "Something wrong on Server!!!");
			resp.sendRedirect("user/viewExpense.jsp");		}
	}
	
	
}
