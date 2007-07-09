<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:useBean id="book" scope="request" type="meta.library.model.bean.Book" />
<title>
	<jsp:getProperty name="book" property="title" />
</title>
<link rel="stylesheet" type="text/css" href="stylesheets/common.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/book.css" />
</head>
<body>
	<%@ include file="templates/toolbar.jsp"%>

	<div class="list">
		<div class="entry">
			<div class="cover"><img src="cover.do?id=<jsp:getProperty name="book" property="id" />"></img></div>
			<div class="desc">
				<span>Title: <a href="http://localhost:8080/MetaLibrary/book.do?method=info&id=${book.id}"><jsp:getProperty name="book" property="title" /></a></span>
				<span>Author: <jsp:getProperty name="book" property="author" /></span>
				<span>Press: <jsp:getProperty name="book" property="press" /></span>
				<span>ISBN: <jsp:getProperty name="book" property="isbn" /></span>
				<span>Catalog: <jsp:getProperty name="book" property="catalog" /></span>
				<span>Description: <jsp:getProperty name="book" property="description" /></span>
			</div>
			<div class="action">
				<button bookid="<jsp:getProperty name="book" property="id" />" onclick="alert(this.bookid);">Modify</button>
				<button bookid="<jsp:getProperty name="book" property="id" />" onclick="alert(this.bookid);">Delete</button>
			</div>
		</div>
	</div>
</body>
</html>