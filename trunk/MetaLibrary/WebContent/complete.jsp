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
	<jsp:useBean id="actionResultMessage" class="meta.library.model.bean.ActionResultMessage" scope="request"></jsp:useBean>
	<div class="complete">
		<div>
			<jsp:getProperty name="actionResultMessage" property="message" />
		</div>
		<div>
			<a href="<jsp:getProperty name="actionResultMessage" property="url" />">Return</a>
		</div>
	</div>
</body>
</html>