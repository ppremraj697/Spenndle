package com.servlet;

import java.io.IOException;

import com.dao.UserDAO;
import com.db.HibernateUtil;
import com.entity.UserInput;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		UserDAO dao = new UserDAO(HibernateUtil.getSessionFactory());
		UserInput user = dao.login(email, password);
//		System.out.println(user);

		HttpSession session = req.getSession();

		if (user == null) {
			session.setAttribute("msg", "invalid E-mail or Password");
			resp.sendRedirect("login.jsp");
		} else {
			session.setAttribute("loginUser", user);
			resp.sendRedirect("user/home.jsp");
		}
	}
}
