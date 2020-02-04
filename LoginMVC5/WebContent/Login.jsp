<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<%
		String message = (String) request.getAttribute("error");
		if (message != null) {

			out.println("<h1><font color='red'>" + message + "</font></h1>");
		}
	%>
	<form action="LoginServlet" method="post">
		<h1>Login</h1>
		<br> <br>UserName:<input type="text" name="userName" /><br>
		<br>Password:<input type="text" name="password" /><br> <br>
		<input type="submit" value="LOGIN" /><input type="reset"
			value="CLEAR" /><br>
	</form>

</body>
</html>