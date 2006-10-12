 function sendSourceFile(url, fileName, source)
 {
 	var params = "fileName=" + fileName + "&source=" + source;  
 	sendRequest(url, afterSendSourceFile, null, params, "POST"); 	
 }
 
 function afterSendSourceFile(req, sender)
 {
 	var temp = req.responseText;
 	//var result = temp.toJSONObject();
 	//theConsole.clean();
 	theConsole.write(MESSAGE, temp);
 }

function compile() {
	var tabcontainer = dojo.widget.byId("codeareaMainTabContainer");//document.getElementById("mainTabContainer");
	var fileName = tabcontainer.selectedTabWidget.label;
	var doc = getActiveDoc();
	var source = doc.body.innerText;
	sendSourceFile("compile", fileName, source);
}