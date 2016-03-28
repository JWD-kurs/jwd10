<%@ include file="/WEB-INF/jsp/layout/header.jsp" %>

	<table class="table">
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
				<td><a href="/activities/remove/${activity.id }" class="btn btn-default">Remove</a></td>
				<td><a href="/activities/edit/${activity.id }" class="btn btn-default">Edit</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<a href="/activities/add" class="btn btn-default">New activity</a>

<%@ include file="/WEB-INF/jsp/layout/footer.jsp" %>