/**
 * Initializer of the web component
 * Navigatro, Menubar, Toolbar, Codearea, Console
 */
function initComponentById(componentId) {
	var component = document.getElementById(componentId);
	initComponent(component);
}

function initComponent(component) {
	if (component == null) return false;
	var path = component.getAttribute("src");
	/*dojo.io.bind({
		url: path,
		load: function(type, data, evt) {
			fillComponent(data, component);
		},
		mimetype: "text/plain"
	});*/
	sendRequest(path, fillComponent, component);	
}

function fillComponent(content, component) {
	alert(content.responseText);
	component.innerHTML = content.responseText;
}

function CodeArea(codeAreaId) {
	this.area = document.getElementById(codeAreaId);
	this.path = this.area.getAttribute("src");
	this.init = codeAreaInit;
}

function codeAreaInit() {
	sendRequest(this.path, fillCodeArea, this.area);
}

function fillCodeArea(content, codeArea) {
	fillComponent(content, codeArea);
	var frames = codeArea.getElementsByTagName("iframe");
	for (var i = 0; i < frames.length; i++) {
		var doc = frames[i].contentWindow.document;;
		doc.designMode = "on";
	}
}

function CodeFrame(codeFrameId) {
	this.codeFrame = document.getElementById(codeFrameId);
}