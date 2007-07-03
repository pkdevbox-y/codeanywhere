<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="container" style="text-align: left">
	<div id="toolbar" style="text-align: left"></div>
</div>
<link rel="stylesheet" type="text/css" href="scripts/ext/resources/css/ext-all.css" />

<script type="text/javascript" src="scripts/ext/adapter/ext/ext-base.js"></script>
<script type="text/javascript" src="scripts/ext/ext-all.js"></script>

<script type="text/javascript">
	Ext.onReady(function(){
		var homeMenu = new Ext.menu.Menu({
			id: "homemenu",
			items: [
				{text: "Register", href: "user.do?method=register"},
				{text: "Login", href: "user.do?method=login"},
				{text: "Logout", href: "user.do?method=logout"},
				"-",
				{text: "About", href: "about.jsp"}
			]
		});
		var bookMenu = new Ext.menu.Menu({
			id: "bookmenu",
			items: [
				{text: "Add a book", href: "book.do?method=add"},
				{text: "Borrow a book", href: "borrow.do?method=borrow"},
				"-",
				{text: "List all books", href: "book.do?method=list"}
			]
		});
		
		var toolbar = new Ext.Toolbar("toolbar");
		
		toolbar.add({
			text: "Home",
			menu: homeMenu
		},
		{
			text: "Book",
			menu: bookMenu
		});
		
		Ext.get(document.body).addClass('x-gray');
	});
</script>