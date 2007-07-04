<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meta Library</title>
<link rel="stylesheet" type="text/css" href="stylesheets/common.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/index.css" />

</head>
<body>
	<%@ include file="templates/toolbar.jsp"%>
	<div class="logo"><img src="images/logo.gif"></img></div>
	<form id="searchform" action="search.do" method="post">
		<div>
		<input id="search" name="search" type="text"></input>
		<input id="submitbutton" type="submit" value="Search"></input>
		</div>
	</form>
	<div class="footer">&copy;2007 MT Library</div>
</body>
</html>