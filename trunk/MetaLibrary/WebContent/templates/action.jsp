<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="meta.library.model.bean.User" %>

	<%
		User user = (User) session.getAttribute("user");
		if (user == null) {
	%>
	<span><a href="user.do?method=register">Register</a></span>
	<span><a href="user.do?method=login">Login</a></span>
	<% 
		} else if (user.getPriviledge() == 7) {
	%>
		[Modify][Delete]
	<%
		}
	%>