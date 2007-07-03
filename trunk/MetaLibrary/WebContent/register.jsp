<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="stylesheets/common.css" />
<link rel="stylesheet" type="text/css" href="stylesheets/form.css" />

<script type="text/javascript" src="scripts/prototype.js"></script>
<script type="text/javascript" src="scripts/register.js"></script>

<script type="text/javascript">
	function Init()
	{
		Event.observe($("submitbutton"), "click", OnRegister, true);
		/*Ajax.Responders.register(
			{
				onCreate: ShowProcessingTip,
				onComplete: EndShowProcessingTip
			});*/
	}
	Event.observe(window, "load", Init, false);
</script>
</head>
<body>
	<%@ include file="templates/toolbar.jsp"%>
	<form id="registerform" action="user.do?method=register" method="post">
		<div class="header"><h3>Meta Library</h3></div>
		<div id="content" class="content">
			<span id="hint">Please enter your information</span>
			
			<div>
				<label for="username">Username:</label>
				<input id="username" name="username" type="text"></input>
			</div>
			
			<div>
				<label for="password">Password:</label>
				<input id="password" name="password" type="password"></input>
			</div>
			
			<div>
				<label for="confirmpassword">Confirm Password:</label>
				<input id="confirmpassword" name="confirmpassword" type="password"></input>
			</div>
			
			<div>
				<label for="email">Email:</label>
				<input id="email" name="email" type="text"></input>
			</div>
			
			<div id="submitdiv">
				<input id="submitbutton" type="submit" value="Register"></input>
			</div>
			
		</div>
	</form>

</body>
</html>