<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WAFEPA - Users</title>
</head>

<table class="table table-bordered">
	<thead>
		<tr>
			<th>ID</th>
			<th>Email</th>
			<th>Password</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${usersModel}" var="user">
			<tr>	
				<td><c:out value="${user.id}" /></td>				
				<td><c:out value="${user.email}" /></td>
				<td><c:out value="${user.password}" /></td>
				<td><c:out value="${user.firstname}" /></td>
				<td><c:out value="${user.lastname}" /></td>
				<td>
					<a href="users/remove/${user.id}">remove</a>
					
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>


</body>
</html>