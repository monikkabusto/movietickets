<%@ include file="/WEB-INF/views/_taglibs.jspf"
%><!DOCTYPE html>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/WEB-INF/views/_taglibs.jspf"%>

<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title><fmt:message>
		<tiles:insertAttribute name="title" />
	</fmt:message> - MovieTickets</title>
<link href="<c:url value="/favicon.ico" />" rel="icon" type="image/png" />
<link type="text/css" rel="stylesheet"
	href="<c:url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css" />" />

</head>
<body>
	<security:authorize> access="isAuthenticated()">
		<li class=""><c:url var="logoutUrl" value='/logout' /> <a
			href="${logoutUrl}"
			onclick="getElementById('_logoutForm').submit(); return false;"><fmt:message
					key="navigate.logout" /></a> <%--
						Because CSRF is enabled, and a token is expected, a logout link will
						not be enough. You'll need to use a POST. You can do this by creating
						a hidden form that is submitted when the logout link is clicked.
						Use Spring form:form tag when creating this hidden logout form
						to automatically include the CSRF token.
					--%> <form:form id="_logoutForm" action="${logoutUrl}"
				method="POST" cssClass="hidden"></form:form></li>
	</security:authorize>
	<tiles:insertAttribute name="main" />


</body>
</html>



