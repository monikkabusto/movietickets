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

h1 {
	color: #b04553;
	font-size: 20px;
}

input[type=checkbox] {
	display: none;
	height: 50px;
	width: 50px;
}

input[type=checkbox]+label {
	background: #d7eae5;
	border: 1px solid #ccc;
	height: 40px;
	width: 40px;
	display: inline-block;
	padding: 0 0 0 0px;
}

input[type=checkbox]:checked+label {
	background: #d98c9e;
	height: 40px;
	width: 40px;
	display: inline-block;
	color: green;
	padding: 0 0px 0 0px;
}

.imageSmall {
	align: right;
	height: 50px;
	width: 80%;
	overflow: hidden;
	margin-bottom: 50px;
	margin-top: 20px;
}

label {
	margin-right: 10px
}
</style>
</head>
<body>
	<h1>${title}</h1>
	<img class="imageSmall"
		src="${pageContext.request.contextPath}/images/screen.jpg" />
	<p></p>
	<%--  	<form:form method="POST" modelAttribute="transaction" action="printTicket">
		<form:checkboxes path="bookedSeats" items="${bookedSeats}" />
		<br>
		<input type="hidden" name="price" value="${price}"/>
		<input type="hidden" name="showId" value="${showId}"/>
		<input class="btn" type="submit" value="Book Tickets" /> 
	</form:form>  --%>

	<form:form method="POST" modelAttribute="transaction"
		action="printTicket">
		<c:forEach var="seat" items="${bookedSeats}" varStatus="i">
			<form:checkbox name="${seat}" id="${seat}" label="${seat}"
				path="bookedSeats" value="${seat}" />
			<c:if test="${((i.index + 1) % 3) == 0}">
				<p></p>
			</c:if>
		</c:forEach>
		<input type="hidden" name="price" value="${price}" />
		<input type="hidden" name="showId" value="${showId}" />
		<input class="btn" type="submit" value="Book Tickets" />
	</form:form>

	<%-- 
 	 	<c:forEach var="seat" items="${bookedSeats}" varStatus="i">
		<form:checkbox name="${seat}" id="${seat}" label="${seat}" path="bookedSeats" value="seat"/>
			<c:if test="${((i.index + 1) % 3) == 0}">
				<p></p>
			</c:if>
		</c:forEach> --%>
</body>
</html>
