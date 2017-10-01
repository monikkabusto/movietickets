<%@ include file="/WEB-INF/views/_taglibs.jspf"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link
	href="https://fonts.googleapis.com/css?family=Anton|Fjalla+One|Oswald"
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

.nowshowing {
	padding: 0px 0px 0px 0px;
	margin-bottom: 20px;
}

.nowshowing p {
	color: #d98c9e;
	text-shadow: 2px 2px 8px #d7eae5;
}

.imageSmall {
	align: right;
	height: 200px;
	overflow: hidden;
}

h1 {
	color: #b04553;
}

.price {
	color: #1c0e17;
}

.nav {
	margin-right: 10px;
	margin-top: 10px;
	float: right;
}

.btn:hover, .btn:focus {
	box-shadow: inset 0 0 0 2em var(- -hover);
}
</style>
</head>
<body>
	<div class="nav">
		<security:authorize access="isAuthenticated()">
			<c:url var="logoutUrl" value='/logout' />
			<button class="btn btn-info myb"
				onclick="getElementById('_logoutForm').submit(); return false;">
				<fmt:message key="navigate.logout" />
				<form:form id="_logoutForm" action="${logoutUrl}" method="POST"
					cssClass="hidden"></form:form>
			</button>
		</security:authorize>
	</div>
	<h1>Sales Report for All Movie Screenings</h1>

	<c:forEach var="movie" items="${movies}" varStatus="i">
		<div class="col-xs-2 col-m6-2 nowshowing">
			<div class="poster">
				<img class="imageSmall"
					src="${pageContext.request.contextPath}/images/${movie.imageName}"
					alt="Movie X Cinema" />
			</div>
			<p>${movie.movieTitle}</p>
			<span class="price">PHP ${movie.sales}</span>
		</div>
	</c:forEach>
	<a class="button" href="/">Go Back to Home Page</a>
</body>

</html>

