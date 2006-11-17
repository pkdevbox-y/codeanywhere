/*
 * provides a Console class
 * author: Biao Zhang
 * date: 2006-9-24
 */ 
var WARN = 0;
var DEBUG = 1;
var INFO = 2;
var MESSAGE = 4;

function Console(div) {
	this.html = div;
	this.console = document.getElementById(div);
}

Console.prototype.write = function(type, content) {
	if (this.console == null) {
		this.console = document.getElementById(this.html);
	}
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

Console.prototype.clear = function() {
	while (this.console.hasChildNodes()) {
		this.console.removeChild(this.console.firstChild);
	}
}

Console.prototype.read = function() {
	
}

var console = new Console("console");