<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
			<form name="Register" method="POST" action="RegisterServlet">
				<h1>Please Enter your username and password</h1>
				<h3>${msg}</h3>
				<table>
					<tr>
						<td>Enter username:</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td>Enter password:</td>
						<td><input type="password" name="password" /></td>
					</tr>
				</table>
				<br /> <input type="submit" value="Submit" />
				
				<button type="button" OnClick = "location.href= 'home.jsp'">Go home</button>	
			</form>	
</body>
</html>