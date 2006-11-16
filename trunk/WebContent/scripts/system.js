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
	if (checkPassword(un, pw)) {
		alert("Welcome " + un + "!");
		var loginDialog = dojo.widget.byId("loginDialog");
		loginDialog.hide();
	} else {
		alert("Wrong username or password!");
	}
}

function OnRegister()
{
	alert("Not implemented yet~~");
}

function checkPassword(username, password)
{
	if (username == "bbiao" && password == "123456")
		return true;
	else
		return false;
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