/**
 * @description: Listeners of tree in navigate
 * @author: zz
 * @date: 2006-9-29
 */
function restoreIconSrc() {
	//icon was changed during the action => no need to move it back
	//alert("Restore "+this.icon.src.substr(-18))
	if (this.icon.src.substr(-18) != '../icons/loading.jpg') { // check if icon.src is loading icon
		return;
	}
	this.icon.src = this.oldIconSrc;
}

var fileName;

function openClicked(selectedNode, controllerId) {
	alert(selectedNode);
	fileName = selectNode.title;
	var params = "oper=open&fileName=" + fileName + "source=??";
	sendRequest("file", FillFile, null, params, "POST");	
}

function FillFile(req, sender)
{
	var text = req.responseText;
	alert(text);
	OnFileNewClass(fileName, text);
}

/**
 * new a TreeNode from the old one
 */
function newTreeNode(treeNode, name, flag)
{
	var properties = {
		 		dojoType:"TreeNode",
		 		widgetId:name + "_treenode",
		 		id:name + "_treenode",
		 		title:name,
		 		isFolder:flag,
		 		childIconSrc:treeNode.childIconSrc
		 	};	
	var newNode = dojo.widget.createWidget("TreeNode", properties);
	return newNode;
}


/** 
 * add fields and method to the class 
 */
function addFieldAndMethod(fileName, infos) {
	var parentNode = dojo.widget.byId(fileName + "_treenode");
	var newParentNode;
	
	if (parentNode.isFolder == true)
	{
		parentNode.destroyChildren();
	}
	else
	{
		var index = parentNode.getParentIndex();
		var name = parentNode.title;
		newParentNode = newTreeNode(parentNode, name, true);
		var tree = dojo.widget.getWidgetById("project_tree");
		tree.removeChild(parentNode);
		tree.addChild(newParentNode, index);
	}
	
 	var properties;
	
	for (var i = 0; i < infos.length; i++)
	{
		var info = infos[i];
		
		if (info.kind=="Field")
		{
			var field = info.name;
			var type = info.type;
			var icon = "icons/" + getIcon(info.modifier) + "_field.png";
			
			properties = {
		 		dojoType:"TreeNode",
		 		widgetId:field + "_treenode",
		 		id:field + "_treenode",
		 		title:field + " : " + type,
		 		isFolder:false,
		 		childIconSrc:icon
		 	};	
		}
		else if (info.kind=="Method")
		{
			var method = info.name;
			var type = info.type;
			var icon = "icons/" + getIcon(info.modifier) + "_method.png";
			
			properties = {
		 		dojoType:"TreeNode",
		 		widgetId:method + "_treenode",
		 		id:method + "_treenode",
		 		title:method + "() : " + type,
		 		isFolder:false,
		 		childIconSrc:icon
		 	};	
		}

		var treeNode = dojo.widget.createWidget("TreeNode", properties);
	 	newParentNode.addChild(treeNode);
	}
}

/**
 * get the icon of the modifier
 */
function getIcon(modifier) {
	var PUBLIC = 1;
	var PRIVATE = 2;
	var PROTECTED = 4;
	
	if ((modifier & PUBLIC) == PUBLIC)
	{
		return "public";
	}
	else if ((modifier & PROTECTED) == PROTECTED)
	{
		return "protected";
	}
	else if ((modifier & PRIVATE) == PRIVATE)
	{
		return "private";
	}
	else
	{
		return "package";
	}
}


/* process create operation */
function createClicked(selectedNode, controllerId, icon) {
	if (!selectedNode || selectedNode.actionIsDisabled(selectedNode.actions.ADDCHILD)) {
		return false;
	}

	this.icon = icon;
	this.oldIconSrc = icon.src;

	this.controller = dojo.widget.manager.getWidgetById(controllerId);

	if (!selectedNode || !selectedNode.isFolder) {
		alert('Select folder please');
		return false;
	}

	this.icon.src = '../icons/loading.jpg';

	// I send some data to server and recieve feedback with right node
	var res = controller.createChild(selectedNode, 0, { suggestedTitle: "New Node" }, dojo.lang.hitch(this, restoreIconSrc));

	// local checks failed
	if (res == false) {
		restoreIconSrc.apply(this);
	}
}

function removeClicked(selectedNode) {

	if (!selectedNode) {
		alert('No Class selected');
		return false;
	}
	
	var fileName = selectedNode.title;
	var tree = dojo.widget.getWidgetById("project_tree");
	tree.removeChild(selectedNode);
	
	var tab = dojo.widget.getWidgetById(fileName + "_tab");
	var tabcontainer = dojo.widget.getWidgetById("codeareaMainTabContainer");
	tabcontainer.removeChild(tab);	

}

/**
 * rename the node
 */
function renameClicked(selectedNode) {
		
	if (!selectedNode) 
	{
		alert('No Class selected');
		return false;
	}
	else
	{
		var index = selectedNode.getParentIndex();
		
		//it should be got dynamicly
		var newName = "zz";
		var oldName = selectedNode.title;
		var newNode = newTreeNode(selectedNode, newName, false);
		var tree = dojo.widget.getWidgetById("project_tree");
		tree.removeChild(selectedNode);
		tree.addChild(newNode, index);
		renameTab(oldName, newName);
	}
}

/**
 * rename a tab
 */
function renameTab(oldName, newName) {
	
	var tab = dojo.widget.getWidgetById(oldName + "_tab");
	
	var div = getDivByFileName(oldName);
	//alert(div.innerText);
	var tabcontainer = dojo.widget.getWidgetById("codeareaMainTabContainer");
	tabcontainer.removeChild(tab);	
	
	OnFileNewClass(newName,div.innerHTML);
}

var reporter = function(reporter) {
	this.name = eventName;
	this.go = function(message) {
		var rep = [ reporter + " -- event: "+this.name ];
		for(i in message) rep.push(i+": "+message[i]);
		dojo.debug(rep.join(', '));
	}
}

dojo.addOnLoad(function() {

	/* Add debug print for all controller events */
	var controller = dojo.widget.manager.getWidgetById('treeController');
	for(eventName in controller.eventNames) {
		dojo.event.topic.subscribe(
			controller.eventNames[eventName],
			new reporter('controller'),
			'go'
		);
	}

	/* Add debug print for all tree events */
	var tree = dojo.widget.manager.getWidgetById('project_tree');
	for(eventName in tree.eventNames) {
		dojo.event.topic.subscribe(
			tree.eventNames[eventName],
			new reporter('project_tree'),
			'go'
		);
	}

});

/* setup menu actrions */
dojo.addOnLoad(function() {
	
	dojo.event.topic.subscribe('treeContextMenuOpen/engage',
		function (menuItem) { openClicked( menuItem.getTreeNode(), 'treeController'); }
	);

	dojo.event.topic.subscribe('treeContextMenuCreate/engage',
		function (menuItem) { createClicked( menuItem.getTreeNode(), 'treeController',  menuItem.getTreeNode().expandIcon); }
	);

	dojo.event.topic.subscribe('treeContextMenuRemove/engage',
		function (menuItem) { removeClicked( menuItem.getTreeNode()); }
	);
	
	dojo.event.topic.subscribe('treeContextMenuRename/engage',
		function (menuItem) { renameClicked( menuItem.getTreeNode()); }
	);

});



