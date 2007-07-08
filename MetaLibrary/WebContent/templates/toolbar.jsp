<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="meta.library.model.bean.User" %>
	<style type="text/css">
		html body {
			margin: 0;
			padding: 0;
			text-align: center;
		}
	</style>
	
	<div class="toolbar">
	<span class="link"><a href="index.jsp">Home</a></span>
	<span class="link"><a href="addbook.jsp">Add a book</a></span>
	<span class="link"><a href="book.do?method=list">List books</a></span>
	<span class="link"><a href="borrow.do?method=borrow">Borrow a book</a></span>
	<span class="link"><a href="borrow.do?method=list">Borrowed books</a></span>
	<span class="link"><a href="about.jsp">About</a></span>
	
	<%
		User user = (User) session.getAttribute("user");
		if (user == null) {
	%>
	<span><a href="user.do?method=register">Register</a></span>
	<span><a href="user.do?method=login">Login</a></span>
	<% 
		} else {
	%>
	<span>Hello, <%= user.getUsername() %></span>
	<span><a href="user.do?method=logout">Logout</a></span>
	<%
		}
	%>

	</div>