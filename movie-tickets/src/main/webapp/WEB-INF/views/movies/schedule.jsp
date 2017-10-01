<%@ include file="/WEB-INF/views/_taglibs.jspf"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
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

input[type=checkbox] {
	display: inline;
}

label {
	display: inline;
}

body {
	margin-left: 100px;
}

input[type=text] {
	width: 30%;
	padding: 12px 20px;
	margin: 8px 0;
	box-sizing: border-box;
	border: 3px solid #d98c9e;
	-webkit-transition: 0.5s;
	transition: 0.5s;
	outline: none;
	height: 20px;
	opacity: 0.5;
}

input[type=text]:focus {
	border: 3px solid #5f5f87;
}

.container span {
	display: inline-block;
	width: 70px;
}

.div span {
	display: inline-block;
	width: 70px;
}

#addMovie {
	display: none;
}
.nav {
	margin-right: 10px;
	margin-top: 10px;
	float: right;
}

.btn:hover, .btn:focus {
	box-shadow: inset 0 0 0 2em var(- -hover);
}
myb {
	float: right;
}
</style>
</head>
<script>
	function addMovie(a) {
		if (a == 1)
			document.getElementById("addMovie").style.display = "none";
		else
			document.getElementById("addMovie").style.display = "block";

	}
</script>
<body>
	<security:authorize access="isAuthenticated()">
			<c:url var="logoutUrl" value='/logout' />
			<button class="btn btn-info myb"
				onclick="getElementById('_logoutForm').submit(); return false;">
				<fmt:message key="navigate.logout" />
				<form:form id="_logoutForm" action="${logoutUrl}" method="POST"
					cssClass="hidden"></form:form>
			</button>
	</security:authorize>
	<h1>MovieX Cinema Scheduler</h1>
	<h2>Select Movies to Schedule for next week</h2>
	<form:form method="POST" modelAttribute="MoviesToSchedule"
		action="" name="form">
		<form:checkboxes path="moviesToSchedule" items="${existingMovies}"
			delimiter="<br/><p></p>" />
		<p></p>
		<h3>Would you like to add another movie?</h3>

		<form:radiobutton name="yesno" id="yesCheck"
			onclick="javascript:yesnoCheck();" path="addMovie" value="true"
			label="Yes" />
		<form:radiobutton name="yesno" id="noCheck"
			onclick="javascript:yesnoCheck();" path="addMovie" value="false"
			label="No" checked="checked" />
		<br>
		<div id="ifYes" style="display: none">

			<div class="container">
				<span>Title :</span>
				<form:input label="movieTitle" path="newMovieDetails"
					id="movieTitle" name="movieTitle" />
			</div>
			<div class="container">
				<span>Director :</span>
				<form:input label="director" path="newMovieDetails" id="director" name="director" />
			</div>
			<div class="container">
				<span>Year :</span><form:input path="newMovieDetails" id="year" name="year"/>
			</div>
			<div class="container">
				<span>Duration :</span><form:input id="duration" name="duration" path="newMovieDetails"/>
			</div>
			<div class="container">
			<span>Rating :</span><form:input label="rating" path="newMovieDetails" id="rating" name="rating"/>
			</div>
			<div class="container">
			<span>Genre :</span><form:input type="text" path="newMovieDetails" id="rating" name="genre"/>
			</div>
			<div class="container">
			<span>Cast :</span><form:input type="text" id="rating" name="castmembers" path="newMovieDetails"/>
			</div>
			<p>
				<input class="btn" type="submit" value="AddMovie" onclick="addMovie();"/>
			</p>
		</div>

		<input class="btn" type="submit" value="Schedule Movies" onclick="scheduleMovies();"/>
		<label> Cinema : <select name="cinemaId">
				<c:forEach var="cinema" items="${cinemas}" varStatus="i">
					<option value="${cinema.id}">${cinema.venue}</option>
				</c:forEach>
		</select>
		</label>


	</form:form>
</body>
<script type="text/javascript">
	function yesnoCheck() {
		if (document.getElementById('yesCheck').checked) {
			document.getElementById('ifYes').style.display = 'block';
		} else
			document.getElementById('ifYes').style.display = 'none';

	}
</script>
<script>
function addMovie()
{
 document.form.action ="schedule";
}
function scheduleMovies()
{
document.form.action = "scheduled";
}
</script>
</html>

