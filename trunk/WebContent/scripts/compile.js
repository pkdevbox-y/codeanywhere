 function sendSourceFile(url, fileName, source)
 {
 	var params = "fileName=" + fileName + "&source=" + source;  
 	alert(params);
 	sendRequest(url, afterSendSourceFile, null, params, "POST"); 	
 }
 
 function afterSendSourceFile(req, sender)
 {
 	var temp = req.responseText;
 	//var result = temp.toJSONObject();
 	theConsole.write(MESSAGE, temp);
 }

function compile() {
	var fileName = "Hello";
	var doc = getActiveDoc();
	var source = doc.body.innerText;
	sendSourceFile("compile", fileName, source);
}