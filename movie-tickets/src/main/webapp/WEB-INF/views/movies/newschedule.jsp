<%@ include file="/WEB-INF/views/_taglibs.jspf"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
	${moviesToSchedule }
</body>
</html>

