function search() {
	var strText = document.getElementById("search").value;
	var activeDoc = getActiveDoc();
	if (activeDoc == null) {
		alert("FUCK");
		return;
	}
	var content = activeDoc.body.innerHTML;
	doSearch(strText, content, activeDoc.body);	
}

function doSearch(str, content, body) {
	var re = new RegExp(str, "g");
	var newstr = content.replace(re, "<span style='background-color: yellow;'>" + str + "</span>");
	body.innerHTML = newstr;
}