<%@ include file="/WEB-INF/views/_taglibs.jspf"%>
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
<footer class="footer">
	<div class="container">
		<p class="text-muted">
			<fmt:message key="footer.message" />
		</p>
	</div>
</footer>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="<c:url value='/webjars/jquery/1.11.1/jquery.min.js' />"></script>
<script
	src="<c:url value='/webjars/bootstrap/3.3.6/js/bootstrap.min.js' />"></script>

