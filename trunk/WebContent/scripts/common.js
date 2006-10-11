/**
 * This file offer some common function to change the "IDE Window" and the
 * explorer status
 *
 */ 
 
 function setIDEWindowTitle(windowTitle) {
 	var titlebartext = document.getElementById("titlebartext");
 	titlebartext.innerHTML = "codeAnywhere - " + windowTitle;
 }