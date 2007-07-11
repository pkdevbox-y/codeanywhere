<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meta Library - Return Book</title>
<link rel="stylesheet" type="text/css" href="stylesheets/common.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/form.css" />
</head>
<body>
	<%@ include file="templates/toolbar.jsp"%>
	<form action="borrow.do?method=returnBook" method="post">
		<div class="header"><h3>Meta Library</h3></div>
		<div class="content">
			<div>
				<label for="borrowid">Borrow Id:</label>
				<input id="borrowid" name="borrowid" type="text"></input>
			</div>			
			
			<div id="submitdiv">
				<input id="submitbutton" type="submit" value="Borrow"></input>
			</div>
		</div>
	</form>
</body>
</html>