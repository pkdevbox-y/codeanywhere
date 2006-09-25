var READY_STATE_UNINITIALIZED = 0;
var READY_STATE_LOADING = 1;
var READY_STATE_LOADED = 2;
var READY_STATE_INTERACTIVE = 3;
var READY_STATE_COMPLETE = 4;

var xmlHttpVer = ["MSXML2.XMLHttp.5.0", "MSXML2.XMLHttp.4.0",
				  "MSXML2.XMLHttp.3.0", "MSXML2.XMLHttp", "Microsoft.XMLHttp"];

function sendRequest(url, parseMethod, sender, params, httpMethod) {
	if (!httpMethod) {
		httpMethod = "GET";
	}
	
	var req = initXMLHttpRequest();
	
	if (req) {
		req.onreadystatechange = function() { onReadyHandler(parseMethod, req, sender); };
		req.open(httpMethod, url, true);
		req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		req.send(params);
	}
}

function initXMLHttpRequest() {
	var xRequest = null;
	if (window.XMLHttpRequest) {
		xRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		for (var i = 0; i < xmlHttpVer.length; i++) {
			try {
				xRequest = new ActiveXObject(xmlHttpVer[i]);
				break;
			} catch (error) {
				// no operation
			}
		}
	}
	return xRequest;
}

function onReadyHandler(parseMethod, req, sender) {
	var ready = req.readyState;
	if (ready == READY_STATE_COMPLETE) {
		parseMethod(req, sender);
	} else {
	
	}
}