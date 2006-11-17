function compile() {
	format();
	var tabcontainer = dojo.widget.byId("codeareaMainTabContainer");//document.getElementById("mainTabContainer");
	var aDiv = getActiveDiv();
	if (aDiv == null) {
		help("compile");
		return;
	}
	var fileName = tabcontainer.selectedTabWidget.label;
	var source = aDiv.innerText;
	var infoBar = document.getElementById("infoBar");
	infoBar.style.display = "inline";
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
 		console.clear();
 		var array = jsonObject.info.parseJSON();
 		for (var i = 0; i < array.length; i++) {
 			var jsonWarning = array[i];
 			console.write(WARN, jsonWarning.line + " : " + jsonWarning.message);
 		}
 	} else if (jsonObject.status == "succeed") {
 		console.clear();
 		console.write(INFO, "Process completed.")
 		var array = jsonObject.info.parseJSON();
 		addFieldAndMethod(jsonObject.fileName, array);
 		/*
 		for (var i = 0; i < array.length; i++) {
 			var o = array[i];
 			alert(o.type + " : " + o.name + "@" + o.kind);
 		}
 		*/
 	}
}
 
function run() {		
	var tabcontainer = dojo.widget.byId("codeareaMainTabContainer");
	var aDiv = getActiveDiv();
	if (aDiv == null) {
		help("run");
		return;
	}
	var fileName = tabcontainer.selectedTabWidget.label;
	runFile("run", fileName);
}

function runFile(url, fileName)
 {
 	var params = "fileName=" + fileName;  
 	sendRequest(url, afterRunFile, null, params, "POST"); 	
 }
 
function afterRunFile(req, sender) {
	var temp = req.responseText;
	console.clear();
 	console.write(MESSAGE, temp);
}