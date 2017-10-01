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
</style>
</head>
<body>
	<h1>You have scheduled the following movies to be shown in
		${cinema.venue}</h1>
	<c:forEach var="movie" items="${moviesToSchedule}">
		<p>${movie}</p>
	</c:forEach>
</body>
</html>
