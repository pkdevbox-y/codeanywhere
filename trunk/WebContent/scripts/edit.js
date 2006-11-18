/**
 * @description: 
 * @author: zz
 * @date: 2006-10-5
 */
function getDivByFileName(fileName) {
	var id = fileName + "_tab_div";
	var div = document.getElementById(id);
	return div;
}

function getActiveDiv() {
	var tabcontainer = dojo.widget.byId("codeareaMainTabContainer");//document.getElementById("mainTabContainer");
	var selectedTab = tabcontainer.selectedTabWidget;
	if (selectedTab == null)
		return null;
	var widgetId = selectedTab.widgetId;
	var activeDiv = document.getElementById(widgetId + "_div");
	return activeDiv;
}

function getActiveHTML() {
	var activeDiv = getActiveDiv();
	return activeDiv.innerHTML;
}

function getActiveText() {
	var activeDiv = getActiveDiv();
	return activeDiv.innerText;
}

function OnCommand(cmd, userInterface, value){
	//var doc = getActiveDoc(); //("codeframe1").contentWindow.document;
	document.execCommand(cmd, userInterface, value);
}


