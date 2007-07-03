function OnLogin(evt)
{
	Event.stop(evt);
	var URL = "ajax/login.do"
	var pars = Form.serialize($("loginform"));
	
	var request = new Ajax.Request(
		URL,
		{
			method: "post",
			parameters: pars,
			onComplete: DoLogin
		});
}
	
function DoLogin(request)
{
	var result = request.responseText;
	if (result == "true") {
		$("loginform").submit();
	} else {
		var tip = $("hint");
		tip.addClassName("alert");
		tip.update("<font color=\"red\">Wrong username or password</font>");
	}
}

function ShowProcessingTip() {
	var tip = $("hint");
	tip.addClassName("info");
	tip.update("Processing your request");
}

function EndShowProcessingTip() {
	var tip = $("hint");
	tip.removeClassName("info");
}