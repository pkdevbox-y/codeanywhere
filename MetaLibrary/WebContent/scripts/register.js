function CheckForm(form) {
	var fields = form.getElements();
	var pswd = fields[1];
	var cfm = fields[2];
	
	var result = true;
	
	for (var i = 0; i < fields.length - 1; i++) {
		if (fields[i].value == null || fields[i].value.length == 0) {
			Element.removeClassName(cfm.parentNode, "right");
			Element.addClassName(fields[i].parentNode, "wrong");
			
			result = false;
		} else {
			Element.removeClassName(cfm.parentNode, "wrong");
			Element.addClassName(fields[i].parentNode, "right");
		}
	}
	
	if (pswd.value != cfm.value) {
		Element.removeClassName(cfm.parentNode, "right");
		Element.addClassName(cfm.parentNode, "wrong");
		
		result = false;
	}
	
	
	return result;
}

function OnRegister(evt) {
	Event.stop(evt);
	var regform = $("registerform");
	if (CheckForm(regform)) {
		regform.submit();
	}
}

function DoRegister(request) {
	
}
