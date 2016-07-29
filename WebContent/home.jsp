<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h1>
${msg}
</h1>
	<c:choose>
		<c:when test="${login == 'success'}">
			<form name="logout" method="POST" action="home.do">
				<input type="hidden" value="logout" name="action" />
				<input type="hidden" value= "${id}" name="id" />
			    <input type="submit" value="logout" />
			</form>	
		</c:when>
		<c:otherwise>
			<form name="login" method="POST" action="login.do">
				<input type="hidden" value="login" name="action" />
				<h1>Please login</h1>
				<br />
				<h3>Enter login infos</h3>
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
				<br /> <input type="submit" value="Login" />
			</form>		
			
			<button type="button" OnClick = "location.href= 'register.jsp'">Register</button>	
			
		</c:otherwise>
	</c:choose>
</body>
</html>