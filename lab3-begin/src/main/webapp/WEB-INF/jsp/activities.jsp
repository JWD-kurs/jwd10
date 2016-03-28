<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WAFEPA - Activities</title>
</head>
<body>
	<h1>Activities</h1>
	
	<table>
		<thead>
			<tr>
				<th>ID</th><th>Name</th><th>Action</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${activitiesModel}" var="activity">
			<tr>
				<td><c:out value="${activity.id }"></c:out> </td>
				<td><c:out value="${activity.name }"></c:out></td>
				<td><a href="/activities/remove/${activity.id }">remove</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>