/**
 * The console used in the system
 */
var console = null;

function initialize()
{
	console = new Console("console");
}

/**
 * Just show the new class diglog
 */
function OnNewClass()
{
	var dialog = document.getElementById("newDialog");
	dialog.style.display = "inline";
}
/**
 * Get the new class name and new a class;
 */
function DoNewClass()
{
	var editor = document.getElementById("editor");
	var fileName = document.getElementById("filename").value;
	if (fileName == "") {
		alert("Class name can't be null!");
	} else {
		while(editor.hasChildNodes()) {
			editor.removeChild(editor.firstChild);
		}
		console.clear();
		editor["fileName"] = fileName;
		var dialog = document.getElementById("newDialog");
		dialog.style.display = "none";
	}
}

function OnSaveFile()
{
	
	
}

function AfterSaveFile(req, sender)
{
	
}

function OnCompile()
{
	var source = document.getElementById("source").value;
	var source;
	var fileName = editor["fileName"];
	var params = "fileName=" + fileName + "&source=" + source;  
 	sendRequest("compile", AfterCompile, null, params, "POST");
	
}

function AfterCompile(req, sender)
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
 	}
}

function OnRun()
{
	var editor = document.getElementById("editor");
	var params = "fileName=" + editor["fileName"];  
 	sendRequest("run", AfterRun, null, params, "POST");	
}

function AfterRun(req, sender)
{
	var temp = req.responseText;
	console.clear();
 	console.write(MESSAGE, temp);
}