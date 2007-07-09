<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://jakarta.apache.org/taglibs/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All Borrowed Book</title>
<link rel="stylesheet" type="text/css" href="stylesheets/common.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/book.css" />
</head>
<body>
	<%@ include file="templates/toolbar.jsp"%>
	<div class="list">
		<c:forEach var="borrow" items="${requestScope.borrowlist}">
		<div class="entry">
			<span class="item">${borrow.id}</span>
			<span class="item">${borrow.user}</span>
			<span class="item"><a href="book.do?method=info&id=${borrow.book.id}">${borrow.book}</a></span>
			<span class="item">${borrow.date}</span>
			<span class="action"><button>${borrow.id}</button></span>
		</div>
		</c:forEach>
	</div>
</body>
</html>