function search() {
	var strText = document.getElementById("search").value;
	var aDiv = getActiveDiv();
	if (aDiv == null) {
		help("search");
		return;
	}
	var content = aDiv.innerHTML;
	doSearch(strText, content, aDiv);	
}

function doSearch(str, content, body) {
	var re = new RegExp(str, "g");
	var newstr = content.replace(re, "<span style='background-color: yellow;'>" + str + "</span>");
	body.innerHTML = newstr;
}