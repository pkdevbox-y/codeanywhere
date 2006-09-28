/**
 * 
 */
function DisplayTreeContent(){
    this.update = function(message) {
        var clickedTreeNode = message.node;

		var docPane = dojo.widget.byId("docpane");
		var file = clickedTreeNode.object;
		if (!file){
			docPane.setContent("Try clicking doc0, doc1 or doc2 instead...");
		}else{
			docPane.setUrl(file);
		}
    };
}

var displayer = new DisplayTreeContent();

var nodeSelectionTopic = dojo.event.topic.getTopic("nodeSelected");
nodeSelectionTopic.subscribe(displayer, "update");

// display custom loadError or use built in
// works best from live server instead of filesystem
function contentLoadError(e){
	var chkbox = dojo.byId("defaultLoadError");
	if(chkbox && chkbox.checked){
		// use built in
		return;
	}
	e.preventDefault(); // or e.returnValue = false;
	var pane = dojo.widget.byId('docpane')
	pane.setContent("Custom Loaderror goes here<br/><img src='images/x.gif' style='float:left;'/> file not found");
	dialogHandler();// turn off loading dialog
}

// display custom Error(Content java/javascript eval error) or use built in method
function contentExecError(e){
	var chkbox = dojo.byId("defaultEvalError");
	if(chkbox && chkbox.checked){
		// use built in
		return;
	}
	e.preventDefault();
	alert('Oops! error occured:'+arguments[0]);
}

// display loading dialog or use built in "Loading..." message
function contentDownloadStart(e){
	var chkbox = dojo.byId("defaultLoadInfo");
	if(chkbox && chkbox.checked){
		// use built in
		return;
	}
	dialogHandler(e, true);
}

// show / hide loading dialog
function dialogHandler(e, show){
	var dialog = dojo.widget.byId("statusDialog");
	if(show){
		e.preventDefault();
		dialog.show();
		return;
	}
	dialog.hide();
}