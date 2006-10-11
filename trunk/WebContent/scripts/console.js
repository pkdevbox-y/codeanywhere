/*
 * provides a Console class
 * author: Biao Zhang
 * date: 2006-9-24
 */ 
var WARN = 0;
var DEBUG = 1;
var INFO = 2;
var MESSAGE = 4;

function Console(consoleId) {
	this.console = document.getElementById(consoleId);
 	this.write = globalWrite;
 	this.read = globalRead;
 	this.clean = function() { glablaClean(this.console); };
 }
 
function globalWrite(type, content) {
	var message = document.createElement("div");
	switch(type) {
	case WARN:
		message.setAttribute("class", "warn");
		message.setAttribute("className", "warn");
		break;
	case DEBUG:
		message.setAttribute("class", "debug");
		message.setAttribute("className", "debug");
		break;
	case INFO:
		message.setAttribute("class", "info");
		message.setAttribute("className", "info");
		break;
	case MESSAGE:
	default:
		message.setAttribute("class", "message");
		message.setAttribute("className", "message");
		break;
	}
	message.innerHTML = content;
	console.appendChild(message);
 }
 
function globalRead() {
	 
}

function globalClean(c) {
	while (c.hasChildNodes()) {
		c.removeChild(c.childNodes[0]);
	}
}

var theConsole = new Console("console");