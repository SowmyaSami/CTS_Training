package com.demo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.LoginPojo;
import com.demo.service.LoginService;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		LoginPojo loginPojo = new LoginPojo();
		loginPojo.setUserName(userName);
		loginPojo.setPassword(password);

		LoginService loginService = new LoginService();
		LoginPojo returnLoginPojo = loginService.validateLogin(loginPojo);
		if (returnLoginPojo.getRole() == null) {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login.jsp");
			request.setAttribute("error", "Invalid Username/Password");
			// request.setAttribute("result", result);
			requestDispatcher.forward(request, response);
		} else {

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Home.jsp");
			request.setAttribute("loginDetails", returnLoginPojo);
			requestDispatcher.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
