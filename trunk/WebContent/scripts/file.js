/*
 * Listener for menu file
 * author: Biao Zhang
 * date: 2006-9-27
 */

 function OnFileOpen() {
 	/*var dialog = document.getElementById("openfile");	
 	dialog.style.zIndex = "16";*/
 	
 	/*var dialog = document.createElement("div");
 	dialog.id = "openfile";
 	dialog.src = "components/openfiledialog.xml";
 	document.getElementsByTagName("body")[0].appendChild(dialog);
 	sendRequest(dialog.src, fillComponent, dialog);*/ 
 	
 	var properties = {	dojoType:"FloatingPane",
 						id:"openfiledialog",
 						title:"Open File",
 						iconSrc:"icons/openFolder.gif",
 						constrainToContainer:"true",
 						hasShadow:true,
 						resizable:true,
 						taskBarId:"hiddentaskbar",
 						windowState:"normal",
 						displayCloseAction:true,
 						displayMinimizeAction:false,
 						displayMaximizeAction:false,
 						toggle:"explode",
 						style:"width: 400px; height: 300px;"
 					};
	var parentNode = document.getElementById("window");
	dojo.widget.fromScript("FloatingPane", properties, parentNode, "last");
 	 
 }