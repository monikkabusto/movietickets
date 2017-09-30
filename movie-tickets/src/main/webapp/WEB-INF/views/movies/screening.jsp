<%@ include file="/WEB-INF/views/_taglibs.jspf"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isELIgnored="false"%>
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
}

h1 {
	color: #b04553;
}

h2 {
	color: #5f5f87;
}
</style>
</head>
<body>
	<h1>Book Tickets for ${movieTitle}</h1>
	<form>
		<select name="item">
			<c:forEach var="screening" items="${screenings}" varStatus="i">
				<option value="${screening}">${screening}</option>
			</c:forEach>
		</select>
	</form>
</body>

</html>

