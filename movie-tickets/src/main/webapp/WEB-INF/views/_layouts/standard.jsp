<%@ include file="/WEB-INF/views/_taglibs.jspf"
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><fmt:message><tiles:insertAttribute name="title"/></fmt:message> - MovieTickets</title>
	<link href="<c:url value="/favicon.ico" />" rel="icon" type="image/png" />
	<link type="text/css" rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" />" />
</head>
<body>
	<tiles:insertAttribute name="main" />
</body>
</html>
