<%@ include file="/WEB-INF/views/_taglibs.jspf"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<script>
	function date_time(id) {
		date = new Date;
		year = date.getFullYear();
		month = date.getMonth();
		months = new Array('January', 'February', 'March', 'April', 'May',
				'June', 'Jully', 'August', 'September', 'October', 'November',
				'December');
		d = date.getDate();
		day = date.getDay();
		days = new Array('Sunday', 'Monday', 'Tuesday', 'Wednesday',
				'Thursday', 'Friday', 'Saturday');
		h = date.getHours();
		if (h < 10) {
			h = "0" + h;
		}
		m = date.getMinutes();
		if (m < 10) {
			m = "0" + m;
		}
		s = date.getSeconds();
		if (s < 10) {
			s = "0" + s;
		}
		result = '' + days[day] + ' ' + months[month] + ' ' + d + ' ' + year
				+ ' ' + h + ':' + m + ':' + s;
		document.getElementById(id).innerHTML = result;
		setTimeout('date_time("' + id + '");', '1000');
		return true;
	}
</script>
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

.allshowing {
	padding: 0;
	margin-left: 100px;
	margin-right: 100px;
}

.nowshowing {
	padding: 0px 0px 0px 0px; `
	margin-bottom: 20px;
	text-align: center;
}

.nowshowing p {
	color: #d98c9e;
	text-shadow: 2px 2px 8px #d7eae5;
}

.imageSmall {
	align: right;
	height: 150px;
	overflow: hidden;
}

h1 {
	color: #b04553;
}

h2 {
	color: #5f5f87;
}

.btn {
	-webkit-border-radius: 11;
	-moz-border-radius: 11;
	border-radius: 11px;
	-webkit-box-shadow: 0px 1px 3px #300230;
	-moz-box-shadow: 0px 1px 3px #300230;
	box-shadow: 0px 1px 3px #300230;
	color: #ffffff;
	font-size: 12px;
	font-family: 'Fjalla One', sans-serif;
	background: #0b1b26;
	padding: 5px 10px 5px 10px;
	text-decoration: none;
}

.btn:hover {
	background: #2ebf37;
	text-decoration: none;
}

.date {
	text-align: right;
}
</style>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>
				<fmt:message key="welcome.title" />
			</h1>
		</div>
		<div class="row">
			<div class="col-md-6">
				<h2>
					<fmt:message key="movies.book.title" />
				</h2>
			</div>
			<div class="col-md-6 date">

				<span id="date_time"></span> <span id="date_time"></span>
				<script type="text/javascript">
					window.onload = date_time('date_time');
				</script>
			</div>
		</div>
	</div>
	<div class="container-fluid row allshowing">
		<c:forEach var="movie" items="${movies}" varStatus="i">
			<div class="col-6 col-md-3 nowshowing">
				<img class="imageSmall"
					src="${pageContext.request.contextPath}/images/${movie.id}.jpg" />
				<p>${movie.movieTitle}</p>
				<form:form action="showScreening" method="get">
					<input type="hidden" name="id" value="${movie.id}"/>
					<input class="btn" type="submit" value="Book Tickets"/>
				</form:form>
				<p></p>
			</div>
		</c:forEach>
		
		
	</div>
</body>

</html>

