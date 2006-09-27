/*
 * Listener for menu file
 * author: Biao Zhang
 * date: 2006-9-27
 */

 function OnFileOpen() {
 	var dialog = document.getElementById("openfile");	
 	dialog.style.zIndex = "16";
 	
 	/*var dialog = document.createElement("div");
 	dialog.id = "openfile";
 	dialog.src = "components/openfiledialog.xml";
 	document.getElementsByTagName("body")[0].appendChild(dialog);
 	sendRequest(dialog.src, fillComponent, dialog);*/   
 }