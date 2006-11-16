/**
 * This function is mainly used to show help,
 * when the system detects that the operation of the user is not allowed;
 * instead of the previous return null.
 */
function help(problem)
{
	var p = document.getElementById("problem");
	p.innerHTML = "How to use " + problem;
	showHelpFrame();
	window.setTimeout("hideHellpFrame()", 5000);	
}

/**
 * To show the frame contains the information
 * 
 */
function showHelpFrame()
{
	var helpDialog = dojo.widget.byId("helpDialog");
	helpDialog.show();	
}

/**
 * To hide the help frame
 */
function hideHellpFrame()
{
	var helpDialog = dojo.widget.byId("helpDialog");
	helpDialog.hide();	
}