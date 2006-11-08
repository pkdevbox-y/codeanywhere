function compile() {
	var tabcontainer = dojo.widget.byId("codeareaMainTabContainer");//document.getElementById("mainTabContainer");
	var fileName = tabcontainer.selectedTabWidget.label;
	var aDiv = getActiveDiv();
	var source = aDiv.innerText;
	sendSourceFile("compile", fileName, source);
}

function sendSourceFile(url, fileName, source)
{
 	var params = "fileName=" + fileName + "&source=" + source;  
 	sendRequest(url, afterSendSourceFile, null, params, "POST"); 	
}
 
function afterSendSourceFile(req, sender)
{
 	var temp = req.responseText;
 	var jsonObject = temp.parseJSON();
 	if (jsonObject.status == "failed") {
 		var array = jsonObject.info.parseJSON();
 		var len = jsonObject.length;
 		for (var i = 0; i < len; i++) {
 			var jsonWarning = array[i];
 			theConsole.write(WARN, jsonWarning.line + " : " + jsonWarning.message);
 		}
 	} else if (jsonObject.status == "succeed") {
 		theConsole.write(INFO, "Process completed.")
 	}
}
 
function run() {		
	var tabcontainer = dojo.widget.byId("codeareaMainTabContainer");
	var fileName = tabcontainer.selectedTabWidget.label;
	runFile("run", fileName, source);
}

function runFile(url, fileName)
 {
 	var params = "fileName=" + fileName;  
 	sendRequest(url, afterRunFile, null, params, "POST"); 	
 }
 
function afterRunFile(req, sender) {
	var temp = req.responseText;
 	theConsole.write(MESSAGE, temp);
}