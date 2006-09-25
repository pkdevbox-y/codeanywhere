function initButton(btId) {
	var bt = document.getElementById(btId);
	if (bt == null) return;
	bt.onmouseover = function() { buttonMouseOver(this); };
	bt.onmouseout = function() { buttonMouseOut(this); };
	bt.onmousedown = function() { buttonMouseDown(this); };
	bt.onmouseup = function() { buttonMouseOver(this); };
	bt.onmouseout();
}

function buttonMouseOver(bt) {
	bt.setAttribute("class", "mouseover");
	bt.setAttribute("className", "mouseover");
}

function buttonMouseOut(bt) {
	bt.setAttribute("class", "mouseout");
	bt.setAttribute("className", "mouseout");
}

function buttonMouseDown(bt) {
	bt.setAttribute("class", "mousedown");
	bt.setAttribute("className", "mousedown");
}
