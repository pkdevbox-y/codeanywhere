
function OnWikiSearch()
{
	var wikiDialog = dojo.widget.byId("wikiDialog");
	wikiDialog.show();
}

function wikiSearch() {
	var tags = document.getElementById("wikitext").value;
	var params = "tags=" + tags;  
 	sendRequest("wikiSearch", afterWikiSearch, null, params, "POST"); 
}
 
function afterWikiSearch(req, sender)
{
 	var temp = req.responseText;
 	var jsonArray = temp.parseJSON();
 	var index = document.getElementById("index");
 	index.innerText = "";
 	for(var i = 0; i < jsonArray.length; i++) {
 		var jsonObject = jsonArray[i];
 		var item = document.createElement("div");
 		setItemClass(item, "itemOnMouseOut");
 		item.source = jsonObject.source;
 		item.onclick = function() { showSource(this.source); };
 		item.onmouseover = function() { setItemClass(this, "itemOnMouseOver"); };
 		item.onmouseout = function() { setItemClass(this, "itemOnMouseOut"); };
 		item.innerText = jsonObject.title;
 		index.appendChild(item);
 	}
}

function showSource(source) {
	var result = document.getElementById("result");
	result.innerText = source;
}

function setItemClass(item, className) {
	item.setAttribute("class", className);
	item.setAttribute("className", className);
}

function OnPublicWiki()
{
	var wikisource = document.getElementById("sourcetopublic");
	var activeDiv = getActiveDiv();
	if (activeDiv == null) {
		help("wiki");
		return;
	}
	wikisource.value = activeDiv.innerText;
	var dlg = dojo.widget.byId("publicWikiDialog");
	dlg.show();	
}

function DoPublicWiki()
{
	var tags = document.getElementById("tags").value;
	var source = document.getElementById("sourcetopublic").value;
	var tabcontainer = dojo.widget.byId("codeareaMainTabContainer");
	var fileName = tabcontainer.selectedTabWidget.label;
	var params = "tags=" + tags + "&fileName=" + fileName + "&source=" + source;
	sendRequest("wikiPublic", AfterPublicWiki, null, params, "POST")
	
}

function AfterPublicWiki(req, sender)
{
	alert(req.responseText);
	CanclePublicWiki();
}

function CanclePublicWiki()
{
	var dlg = dojo.widget.byId("publicWikiDialog");
	dlg.hide();	
}