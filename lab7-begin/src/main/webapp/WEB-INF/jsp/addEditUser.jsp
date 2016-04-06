<%@ include file="/WEB-INF/jsp/layout/header.jsp"%>

<h1>WAFEPA - Add/Edit user</h1>

<c:url value="/users" var="usersUrl" />

<form:form action="${usersUrl}" method="post" modelAttribute="user"
	class="form-horizontal">

	<form:hidden path="id" />

	<div class="form-group">
		<form:label path="email" cssClass="col-sm-2">Email</form:label>
		<div class="col-sm-6">
			<form:input path="email" type="email" />
			<form:errors path="email" cssStyle="color:red"></form:errors>
		</div>
	</div>


	<div class="form-group">
		<form:label path="password" cssClass="col-sm-2">Password</form:label>
		<div class="col-sm-6">
			<form:input path="password" type="password" />
			<form:errors path="password" cssStyle="color:red"></form:errors>
		</div>
	</div>

	<div class="form-group">
		<form:label path="firstname" cssClass="col-sm-2">First name</form:label>
		<div class="col-sm-6">
			<form:input path="firstname" />
			<form:errors path="firstname" cssStyle="color:red"></form:errors>
		</div>
	</div>

	<div class="form-group">
		<form:label path="lastname" cssClass="col-sm-2">Last name</form:label>
		<div class="col-sm-6">
			<form:input path="lastname" />
			<form:errors path="lastname" cssStyle="color:red"></form:errors>
		</div>
	</div>


	<p>
		<button type="submit">Submit</button>
	</p>
</form:form>

<%@ include file="/WEB-INF/jsp/layout/footer.jsp"%>