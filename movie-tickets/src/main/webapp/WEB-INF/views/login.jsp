<%@ include file="/WEB-INF/views/_taglibs.jspf"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Oswald"
	rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
body {
	font-family: 'Oswald', sans-serif;
	background:
		url(http://www.zimknot.co.zw/wp-content/uploads/2016/07/Savin-NY-Website-Background-Web.jpg);
	text-align: center;
}

.rows {
	margin: auto;
	text-align: center;
	width: 500px;
	position: relative;
	top: 50%;
}
</style>
</head>

<body>
	<h1>MovieX Management</h1>
	<div class="row">
		<c:if test="${param.error != null}">
			<div class="col-xs-12 bg-warning" style="padding: 15px">
				<fmt:message key="login.unsuccessful" />
			</div>
		</c:if>
		<c:if test="${param.logout != null}">
			<div class="col-xs-12 bg-info" style="padding: 15px">
				<fmt:message key="logout.successful" />
			</div>
		</c:if>
	</div>
	<div class="rows">
		<spring:url value="/login" var="securityCheckUrl" />
		<form:form action="${securityCheckUrl}" method="post">
			<div class="form-group">
				<label for="username"><fmt:message key="login.user" /></label> <input
					class="form-control" type="text" id="username" name="username"
					value="<c:out value='${user}'/>" />
			</div>
			<div class="form-group">
				<label for="password"><fmt:message key="login.password" /></label>
				<input class="form-control" type="password" id="password"
					name="password" />
			</div>
			<div class="form-group">
				<div class="checkbox">
					<label> <input type="checkbox"
						name="_spring_security_remember_me" /> <fmt:message
							key="login.remember" />
					</label>
				</div>
			</div>
			<div class="form-group">
				<button class="btn btn-default" type="submit">
					<fmt:message key="login.submit" />
				</button>
			</div>
		</form:form>
	</div>

</body>
</html>
