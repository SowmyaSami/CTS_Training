<%@ page import="com.demo.model.LoginPojo"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<BODY>
	<%
		LoginPojo loginPojo = (LoginPojo) request.getAttribute("loginDetails");
		//String resultdata = (String) request.getAttribute("result");
		//String user=request.getParameter("userName");
		//	out.println("Successful");
	%>
	<h2>
		<font color='green'>Welcome <%=loginPojo.getRole()%>,
		</font><%=loginPojo.getUserName()%>!!LOGIN SUCCESSFUL!!! %>
	</h2>
</BODY>
</html>