function initSplitWindow(wnd1Id, wnd2Id, direction) {
	var wnd1 = document.getElementById(wnd1Id);
	var wnd2 = document.getElementById(wnd2Id);
	var splitBar = document.createElement("div");
	splitBar.setAttribute("class", "splitbar");
	splitBar.setAttribute("className", "splitbar");
	wnd1.parentNode.insertBefore(splitBar, wnd2);
}