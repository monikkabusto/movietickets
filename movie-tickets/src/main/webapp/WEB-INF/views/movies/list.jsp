<%@ include file="/WEB-INF/views/_taglibs.jspf"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
}

.carousel {
	background: #f2e8e2;
	width: 100%;
	max-width: 400px;
	padding: 0px;
}

.carousel .item {
	width: 100%;
	max-width: 400px;
}

.carousel .item img {
	padding: 0px;
	max-width: 400px;
	margin: 0 auto;
}

.movieposters {
	padding: 0;
	margin-left: 150px;
	margin-right: 100px;
	max-width: 400px;
	box-shadow: 0px 0px 50px gray;
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

cinema {
	color: #5f5f87;
}

.main {
	position: absolute;
}

.poster {
	text-align: center;
	color: white;
	background: black;
	align: right;
	height: 200px;
	width: 130px;
	overflow: hidden;
}

div.scroll {
	height: 60px;
	overflow: scroll;
}

.fill:hover, .fill:focus {
	box-shadow: inset 0 0 0 2em var(- -hover);
}

.nav {
	margin-right: 10px; margin-top : 10px;
	float: right;
	margin-top: 10px;
}

.btn:hover, .btn:focus {
	box-shadow: inset 0 0 0 2em var(- -hover);
}
</style>
</head>
<body>
	<div class="nav">
		<security:authorize access="hasAnyRole('SYSREP')">
			<a class="btn" href="/book">Book Tickets</a>
		</security:authorize>
		<security:authorize access="hasAnyRole('SYSAD')">
			<a class="btn" href="/schedule">Schedule Movies</a>
		</security:authorize>
		<security:authorize access="hasAnyRole('MANAGER')">
			<a class="btn" href="/sales">VIEW SALES REPORT</a>
		</security:authorize>
		<security:authorize access="isAuthenticated()">
			<c:url var="logoutUrl" value='/logout' />
			<button class="btn btn-info"
				onclick="getElementById('_logoutForm').submit(); return false;">
				<fmt:message key="navigate.logout" />
				<form:form id="_logoutForm" action="${logoutUrl}" method="POST"
					cssClass="hidden"></form:form>
			</button>
		</security:authorize>
	</div>
	<div class="container">
		<div class="page-header">
			<h1>
				<fmt:message key="welcome.title" />
			</h1>
		</div>
		<p class="lead">
			<fmt:message key="welcome.caption" />
		</p>
	</div>
	<div class="container-fluid row main">
		<div class="movieposters col-xs-6 col-md-6">
			<div id="myCarousel" class="carousel slide" data-ride="carousel"
				data-interval="2400">
				<div class="carousel-inner">
					<div class="item active">
						<img src="${pageContext.request.contextPath}/images/0.jpg" />
					</div>
					<c:forEach var="movie" items="${movies}">
						<div class="item">
							<img
								src="${pageContext.request.contextPath}/images/${movie.imageName}" />
							<div class="carousel-caption"></div>
						</div>
					</c:forEach>
				</div>
				<a class="carousel-control left" href="#myCarousel"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left"></span>
				</a> <a class="carousel-control right" href="#myCarousel"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right"></span>
				</a>
			</div>
		</div>
		<c:forEach var="movie" items="${movies}" varStatus="i">
			<div class="col-xs-2 col-m6-2 nowshowing">
				<div class="poster">
					<img class="imageSmall"
						src="${pageContext.request.contextPath}/images/${movie.imageName}"
						alt="Movie X Cinema" />
				</div>
				<p>${movie.movieTitle}</p>
				<div class="scroll">
					<c:forEach var="screening" items="${screenings}">
						<c:if test="${screening.movieId == i.count}">
							<c:out value="${screening}" />
							<br>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</c:forEach>
	</div>
	<footer class="footer">
		<div class="container">
			<p class="text-muted">
				<fmt:message key="footer.message" />
			</p>
		</div>
	</footer>
</body>
</html>
