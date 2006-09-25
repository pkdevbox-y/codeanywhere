function makeDnd(elementId) {
	var element = document.getElementById(elementId);
	if (element == null) return;
	
	//element.currentX = event.clientX + document.body.scrollLeft;
	//element.currentY = event.clientY + document.body.scrollTop;
	
	element.onmousedown = function() { drag(element); };
	element.onmouseup = function() { drop(element); };
}

function drag(element) {
	element.currentX = event.clientX;
	element.currentY = event.clientY;
	element.onmousemove = function() { move(element); };
}

function move(element) {
	var disX = event.clientX - element.currentX;
	var disY = event.clientY - element.currentY;
	element.currentX = event.clientX ;
	element.currentY = event.clientY;
	element.style.pixelLeft += disX;
	element.style.pixelTop += disY;
}

function drop(element) {
	element.onmousemove = null;
}