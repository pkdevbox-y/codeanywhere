/*
 * Listener for menu file
 * author: Biao Zhang
 * date: 2006-9-27
 */

var newClassDialog = 0;
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
 						constrainToContainer:true,
 						hasShadow:true,
 						resizable:true,
 						taskBarId:"hiddentaskbar",
 						windowState:"normal",
 						displayCloseAction:true,
 						displayMinimizeAction:false,
 						displayMaximizeAction:false,
 						toggle:"explode"
 					};
	//var parentNode = document.getElementById("window");
	//dojo.widget.fromScript("FloatingPane", properties, parentNode, "last");
 	
 	var dialog = document.createElement("div");
 	dialog.src = "components/openfiledialog.xml";
 	dialog.setAttribute("class", "openfiledialog");
 	dialog.setAttribute("className", "openfiledialog");
 	document.body.appendChild(dialog);
 	sendRequest(dialog.src, fillComponent, dialog);
 	
 	dojo.widget.createWidget("FloatingPane", properties, dialog);
 }

 function OnNewButtonClick() {
 	var fileName = document.getElementById("newclassname").value;
 	OnFileNewClass(fileName); 	
 	OnNewTreeNode(fileName);
 }
 function OnFileNewClass(fileName, text) {
 	var properties = {
 		dojoType:"ContentPane",
 		widgetId:fileName + "_tab",
 		id:fileName + "_tab",
 		label:fileName
 	};
 	
 	var tabdiv = document.createElement("div");
 	/*var iframeId = properties.id + "_frame";
 	var cframe = document.createElement("iframe");
 	cframe.id = iframeId;
 	cframe.src = "blank.html";
 	cframe.setAttribute("class", "codeframe");
 	cframe.setAttribute("className", "codeframe");
 	cframe.frameBorder = "no";
 	tabdiv.appendChild(cframe);*/
 	var innerdiv = document.createElement("div");
 	if (text!=undefined)
 	{
 		innerdiv.innerHTML = text;
 	}
 	var divid = properties.id + "_div";
 	innerdiv.id = divid;
 	innerdiv.setAttribute("class", "codeframe");
 	innerdiv.setAttribute("className", "codeframe");
 	innerdiv.contentEditable = "true";
 	innerdiv.onkeyup=function() { logCart(this); };
 	innerdiv.onclick=function() { logCart(this); };
 	innerdiv.onselect=function() { logCart(this); };
 	innerdiv.onkeydown=function() { return insertText(this); };
	tabdiv.appendChild(innerdiv);
 	
 	var parentNode = dojo.widget.getWidgetById("codeareaMainTabContainer");
 	var tab = dojo.widget.createWidget("ContentPane", properties, tabdiv);
 	parentNode.addChild(tab);
 	parentNode.selectTab(tab);
 	
 	/*var doc = cframe.contentWindow.document;
 	doc.designMode = "on";*/
 	
 	setIDEWindowTitle(fileName);
 	//doc.write("<html><head><link rel='stylesheet' type='text/css' href='stylesheets/common.css'/></head><body>" + "public class " + fileName + " {<br/>" + "public static void main(String[] args) {<br/>}<br/>}" + "</body></html>");
 	//doc.body.innerHTML = "public class " + fileName + " {<br>" + "public static void main(String[] args) {<br>}<br>}";
 }

function logCart(obj)
{
   obj.logPos = document.selection.createRange().duplicate();
}

function insertAtCaret (objit, text) 
{
    if (objit.logPos) 
    {
       var logPos = objit.logPos;
       logPos.text= logPos.text.charAt(logPos.text.length - 1) == ' ' ? text + ' ' : text;
    }
    else
    {
         objit.innerText = text;
    }
}


var line = 0;
function insertText(ta)
{
	if (window.event.keyCode == 13) {
		var sv = "  ";		
		if (ta.logPos)
       	{
          	insertAtCaret(ta, "\n");
          	for (var i = 0; i < line; i++) {
          		insertAtCaret(ta, sv);
          	}
          	return false;
       	}
	}
	
	if (window.event.keyCode == 219) {
		line++;
	}
	if (window.event.keyCode == 221) {
		line--;
		insertAtCaret(ta, "");
	}
	
    if (window.event.keyCode == 9)
    {
       var sv = "    ";
       if (ta.logPos)
       {
          insertAtCaret(ta, sv);
       }
       else
       {
          sv = "\n" + sv;
          ta.innerText+= sv;
       }
       return false;
   }
   else
   {
        return true;
   }
}

function OnNewTreeNode(fileName)
{
	var properties = {
 		dojoType:"TreeNode",
 		widgetId:fileName+"_treenode",
 		id:fileName+"_treenode",
 		title:fileName,
 		isFolder:false,
 		childIconSrc:"icons/class_tree.png"
 	};
 	
 	var tree = dojo.widget.getWidgetById("project_tree");
	var treeNode = dojo.widget.createWidget("TreeNode", properties);
 	tree.addChild(treeNode);
}