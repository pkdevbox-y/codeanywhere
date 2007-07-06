<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Complete</title>
<link rel="stylesheet" type="text/css" href="stylesheets/common.css" />
</head>
<body>
	<%@ include file="templates/toolbar.jsp"%>
	<div class="complete">
		<div>
			<%= request.getAttribute("message") %>
		</div>
		<div>
			<a href="<%= request.getAttribute("url") %>">Return</a>
		</div>
	</div>
</body>
</html>