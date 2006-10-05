/**
 * @description: 
 * @author: zz
 * @date: 2006-10-5
 */



function getActiveDoc() {
	var tabcontainer = dojo.widget.byId("codeareaMainTabContainer");//document.getElementById("mainTabContainer");
	var widgetId = tabcontainer.selectedTabWidget.widgetId;
	var activeDoc = document.getElementById(widgetId + "_frame").contentWindow.document;
	return activeDoc; 
	
}
function OnUndo(){
	var doc = getActiveDoc(); //("codeframe1").contentWindow.document;
	doc.execCommand("undo");
}

