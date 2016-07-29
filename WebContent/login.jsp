<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<p>
		${msg}
	</p>		
			<c:choose>
				<c:when test="${admin == 'yes'}">
					<form name="goback" method="GET" action="home.do">
						<br />
						<h3>Current User List</h3>
						<table>
							<c:forEach items="${userList._datas}" var ="user"> 
								<tr>
									<td>id: ${user.id}</td>
									<td>username: ${user.username}</td>
									<td>password: ${user.password}</td>
								</tr>
							</c:forEach>
						</table>
						<br /> 				
			    		<input type="submit" value="Go Back" />
						
					</form>	
				</c:when>
				<c:otherwise>		
					<form name="goback" method="GET" action="home.do">
			    		<input type="submit" value="Go Back" />
					</form>			
				</c:otherwise>
			</c:choose>
</body>
</html>