package com.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.dao.UserDAO;
import com.db.HibernateUtil;
import com.entity.UserInput;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fullName = req.getParameter("fullName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserInput user = new UserInput(fullName, email, password);

		UserDAO dao = new UserDAO(HibernateUtil.getSessionFactory());
		boolean f = dao.saveUser(user);

		HttpSession session = req.getSession();

		if (f) {
			session.setAttribute("msg", "Registered Successfully");
//			System.out.println("Registered Successfully");
			resp.sendRedirect("register.jsp");
		} else {
			session.setAttribute("msg", "Something wrong on Server!!!");
//			System.out.println("Something wrong on Server!!!");
			resp.sendRedirect("register.jsp");
		}
	}
}
