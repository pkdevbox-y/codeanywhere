dojo.addOnLoad(function() {
	//dojo.event.connect(document.getElementById("hider"), "onClick", OnNewButtonClick);
	dojo.event.connect(dojo.widget.byId("File_New_Class"), "onClick", showNewClassDialog);
	dojo.event.connect(dojo.widget.byId("Help_About"), "onClick", showAboutDialog);
	dojo.event.connect(dojo.widget.byId("Help_Wiki"), "onClick", OnWikiSearch);
});

function showNewClassDialog() {
	var dlg = dojo.widget.byId("newDialog");
	dlg.show();
}

function showAboutDialog() {
	var dlg = dojo.widget.byId("aboutDialog");
	dlg.show();
}

function showWikiDialog() {
	var dlg = dojo.widget.byId("wikiDialog");
	dlg.show();
}

function OnCommand(cmd, userInterface, value){
	//var doc = getActiveDoc(); //("codeframe1").contentWindow.document;
	document.execCommand(cmd, userInterface, value);
}
