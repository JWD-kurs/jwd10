<%@ include file="/WEB-INF/jsp/layout/header.jsp" %>

<h1>WAFEPA - Add/edit activity</h1>

<form:form action="/activities" method="post" modelAttribute="activity" class="form-horizontal">

    <form:hidden path="id" />

    <div class="form-group">
        <form:label path="name" cssClass="col-sm-2">Name </form:label>
        <div class="col-sm-6">
            <form:input path="name" cssClass="form-control" />
        </div>
    </div>

    <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">Save</button>
    </div>
  </div>
</form:form>

<%@ include file="/WEB-INF/jsp/layout/footer.jsp" %>