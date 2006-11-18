/**
 * This file define some function in the macro system.
 * 
 */
dojo.addOnLoad(OnLogin);
function OnLogin()
{
	var loginDialog = dojo.widget.byId("loginDialog");
	loginDialog.show();	
}

function doLogin()
{
	var un = document.getElementById("username").value;
	var pw = document.getElementById("password").value;
	checkPassword(un, pw);
}

function OnRegister()
{
	var loginDialog = dojo.widget.byId("loginDialog");
	loginDialog.hide();
	var registerDialog = dojo.widget.byId("registerDialog");
	registerDialog.show();
}

function doRegister()
{
	var un = document.getElementById("usernameToR").value;
	var pw = document.getElementById("passwordToR").value;
	var em = document.getElementById("emailToR").value;
	var params = "username=" + un + "&password=" + pw + "&email=" + em;
	sendRequest("register", handleRegister, null, params, "POST");
}

function cancleRegister()
{
	var registerDialog = dojo.widget.byId("registerDialog");
	registerDialog.hide();
	var loginDialog = dojo.widget.byId("loginDialog");
	loginDialog.show();
}

function handleRegister(req, sender)
{
	var passed = req.responseText;
	if (passed == "true") {
		var registerDialog = dojo.widget.byId("registerDialog");
		registerDialog.hide();
		OnLogin();
	} else {
		alert("Wrong username or password!");
	}
}

function checkPassword(username, password)
{
	var params = "username=" + username + "&password=" + password;
	sendRequest("login", doCheckPassword, null, params, "POST");
}

function doCheckPassword(req, sender)
{
	var passed = req.responseText;
	if (passed == "true") {
		var loginDialog = dojo.widget.byId("loginDialog");
		loginDialog.hide();
		alert("Welcome " + un + "!");
	} else {
		alert("Wrong username or password!");
	}
}

function OnQuit()
{
	var quitDialog = dojo.widget.byId("quitDialog");
	quitDialog.show();
}

function doQuit()
{
	window.close();
}

function cancleQuit()
{
	var quitDialog = dojo.widget.byId("quitDialog");
	quitDialog.hide();
}