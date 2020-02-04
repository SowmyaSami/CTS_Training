package com.demo.dao;

import com.demo.model.LoginPojo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class LoginDAO {
	public LoginPojo validateUser(LoginPojo loginPojo) {
		{
//public String validateUser(String userName, String password) {
			// String result = "failure";
			try {

//loading drivers for mysql
				Class.forName("com.mysql.jdbc.Driver");

//creating connection with the database
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "");

				// PreparedStatement ps = con.prepareStatement("select * from login where
				// userName=? and password=?");
				// ps.setString(1, userName);
				// ps.setString(2, password);
				Statement statement = con.createStatement();
				ResultSet resultSet = statement.executeQuery("Select * from login");

				while (resultSet.next()) {
					if (loginPojo.getUserName().equals(resultSet.getString(1))
							&& loginPojo.getPassword().equals(resultSet.getString(2)))
						// result = "success";
						loginPojo.setRole(resultSet.getString(3));
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
			return loginPojo;
		}
	}
}