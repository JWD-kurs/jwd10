<%@include file="/WEB-INF/jsp/layout/header.jsp" %> 

<h1>Users</h1>

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
					<a href="users/remove/${user.id}" class="btn btn-default">remove</a>
					<a href="users/edit/${user.id}" class="btn btn-default"> edit</a>
					
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

<a href="/users/add" class="btn btn-default">Add new user</a>


</body>
</html>