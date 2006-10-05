/**
 * @description: 
 * @author: zz
 * @date: 2006-10-5
 */



function getActiveDoc() {
	tabcontainer = document.getElementById("mainTabContainer");
	activetab = document.getElementById(tabcontainer.getAttribute("selectedTab"));
	alert(tabcontainer.getAttribute("selectedTab"));
	activedoc = activetab.firstChild.contentWindow.document;
	return activedoc; 
	
}
function OnUndo(){
	var doc = getActiveDoc(); //document.getElementById("codeframe1").contentWindow.document;
	doc.execCommand("undo");
}

