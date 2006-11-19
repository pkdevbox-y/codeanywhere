
var classNames = new Array();
var searchEntries = new Array();
var entryMap = new Object();

dojo.addOnLoad(InitAPISearch);
function init(content) {
	var lines = content.split('\n');
	for (var i = 0; i < lines.length; i++) {
		entry = lines[i].split('\t');
		className[i] = entry[0];
		searchEntries[i] = entry;
		entryMap[entry[i]] = entry;
	}	
}

// Get a range of string that contains str
function getIndex(str) {
	var i = binarySearch(str, 0, classNames.length);
	return i;
}

function getEntry(str) {
	return entryMap[str];
}

function binarySearch(str, i, j) {
	if (j < 0 || i > classNames.length || i > j)
		return i;
	var mid = Math.round(((i + j) / 2) - 0.5);
	if (str > className[mid]) {
		return binarySearch(str, mid + 1, j);
	} else if (str < className[mid]){
		return binarySearch(str, i, mid - 1);
	} else {
		return mid;
	}
}

function OnAPISearch()
{
	var dlg = dojo.widget.byId("apiDialog");
	dlg.show();
}	

function DoAPISearch()
{
	var s = document.getElementById("apiwikitext").value;
	var entry = getEntry(s);
	var index = document.getElementById("index");
 	index.innerText = "";
	for (var i = 1; i < entry.length; i++)
	{
		var item = document.createElement("div");
 		setItemClass(item, "itemOnMouseOut");
 		item.onclick = function() { showAPISource(this.source); };
 		item.onmouseover = function() { setItemClass(this, "itemOnMouseOver"); };
 		item.onmouseout = function() { setItemClass(this, "itemOnMouseOut"); };
 		item.innerText = entry[0];
 		item.source = entry[i];
 		index.appendChild(item);
	}
}

function showAPISource(source)
{
	var rframe = document.getElementById("resultframe");
	rframe.src = source;
}

function setItemClass(item, className) {
	item.setAttribute("class", className);
	item.setAttribute("className", className);
}

function InitAPISearch()
{
	sendeRequest("apicontent", AfterInitAPISearch)	
}

function AfterInitAPISearch(req, sender)
{
	init(req.responseText);
}