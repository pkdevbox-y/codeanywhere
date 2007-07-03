<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib uri="http://jakarta.apache.org/taglibs/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Book List</title>
<link rel="stylesheet" type="text/css" href="stylesheets/common.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/book.css" />
</head>
<body>
	<%@ include file="templates/toolbar.jsp"%>
	<div class="list">
		<c:forEach var="book" items="${requestScope.booklist}">
		<div class="entry">
			<div class="cover"><img src="cover.do?id=${book.id}"></img></div>
			<div class="desc">
				<span>Title: ${book.title} </span>
				<span>Author: ${book.author} </span>
				<span>ISBN: ${book.isbn} </span>
				<span>Catalog: ${book.catalog} </span>
				<span>Description: ${book.description} </span>
			</div>
			<div class="action">
				<button bookid="${book.id}" onclick="alert(this.bookid);">Modify</button>
				<button bookid="${book.id}" onclick="alert(this.bookid);">Delete</button>
			</div>
		</div>
		</c:forEach>
	</div>
</body>
</html>