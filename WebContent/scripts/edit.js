/**
 * @description: 
 * @author: zz
 * @date: 2006-10-5
 */

var doc = document.getElementById("codeframe1").contentWindow.document;

function OnUndo(){
	alert("shit");
	doc.execCommand("undo");
}

