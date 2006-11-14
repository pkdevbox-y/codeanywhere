function wikiSearch() {
	var tags = document.getElementById("searchtext").value;
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