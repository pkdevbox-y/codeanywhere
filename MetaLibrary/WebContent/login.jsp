<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login In</title>

<link rel="stylesheet" type="text/css" href="stylesheets/common.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/form.css" />

<script type="text/javascript" src="scripts/prototype.js"></script>
<script type="text/javascript" src="scripts/login.js"></script>
<script type="text/javascript">
	function Init()
	{
		Event.observe($("submitbutton"), "click", OnLogin, true);
		Ajax.Responders.register(
			{
				onCreate: ShowProcessingTip,
				onComplete: EndShowProcessingTip
			});
	}
	Event.observe(window, "load", Init, false);
</script>
</head>
<body>
	<%@ include file="templates/toolbar.jsp"%>
	<form id="loginform" action="user.do?method=login" method="post">
		<div class="header"><h3>Meta Library</h3></div>
		<div id="content" class="content">
			<span id="hint" class="hint">Please enter your username and password</span>
			<div>
			<label for="username">Username:</label>
			<input id="username" name="username" type="text"></input>
			</div>
			<div>
			<label for="password">Password:</label>
			<input id="password" name="password" type="password"></input>
			</div>
			<div id="submitdiv">
			<input id="submitbutton" type="submit" value="Login"></input>
			</div>
		</div>
	</form>
</body>
</html>