/**
 * @description: 
 * @author: zz
 * @date: 2006-10-5
 */



function OnUndo(){
	var doc = document.getElementById("codeframe1").contentWindow.document;
	doc.execCommand("undo");
}

