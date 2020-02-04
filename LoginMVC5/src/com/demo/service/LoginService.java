package com.demo.service;
import com.demo.dao.LoginDAO;
import com.demo.model.LoginPojo;
public class LoginService {
	public LoginPojo validateLogin(LoginPojo loginPojo) {
		//String result = null;
		LoginDAO loginDao = new LoginDAO();
		return loginDao.validateUser(loginPojo);
		
	}

}