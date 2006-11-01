dojo.addOnLoad(function() {
	//dojo.event.connect(document.getElementById("hider"), "onClick", OnNewButtonClick);
	dojo.event.connect(dojo.widget.byId("File_New_Class"), "onClick", showNewClassDialog);

});

function showNewClassDialog() {
	var dlg = dojo.widget.byId("newDialog");
	dlg.show();
}