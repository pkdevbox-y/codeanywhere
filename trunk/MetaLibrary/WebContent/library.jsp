<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://jakarta.apache.org/taglibs/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Meta Library</title>
<link rel="stylesheet" type="text/css" href="stylesheets/common.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/form.css" />
</head>
<body>
	<%@ include file="templates/toolbar.jsp"%>
	<form action="borrow.do?method=borrow" method="post">
		<div class="header"><h3>Meta Library</h3></div>
		<div class="content">
			<div>
				<label for="book">Book:</label>
				<select name="book">
					<c:forEach var="book" items="${requestScope.booklist}">
						<option value="${book.id}">${book.title}</option>
					</c:forEach>
				</select>
			</div>
		
			<div>
				<label for="user">User:</label>
				<select name="user">
					<c:forEach var="user" items="${requestScope.userlist}">
						<option value="${user.id}">${user.username}</option>
					</c:forEach>
				</select>
			</div>
			
			<div>
				<label for="date">Date:</label>
				<input name="date" type="text" value="2007-7-1"></input>
			</div>
			
			<div id="submitdiv">
				<input id="submitbutton" type="submit" value="Borrow"></input>
			</div>
		</div>
	</form>
</body>
</html>