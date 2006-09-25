/*
 * provides a Console class
 * 2006-9-24 Biao Zhang
  */ 
var WARN = 0;
var DEBUG = 1;
var INFO = 2;
var MESSAGE = 4;

function Console(consoleId) {
	this.console = document.getElementById(consoleId);
 	this.write = globalWrite;
 	this.read = globalRead;
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
	this.console.appendChild(message);
 }
 
function globalRead() {
	 
 }