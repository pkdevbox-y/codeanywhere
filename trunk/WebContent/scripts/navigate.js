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

function openClicked(selectedNode, controllerId) {

	//alert(selectedNode);

	var a = new Object();
	a.kind = "Field";
	a.name = "id";
	a.modifier = "help";
	addFieldAndMethod("a", new Array(a));
}

function addFieldAndMethod(fileName, infos)
{
	var parentNode = dojo.widget.getWidgetById(fileName + "_treenode");
	parentNode.destroyChildren();
 	parentNode.isFolder=true;
	var properties;
	
	for (var i=0;i<infos.length;i++)
	{
		
		var info = infos[i];
		//alert(info.name);
		if (info.kind=="Field")
		{
			var field = info.name;
			properties = {
		 		dojoType:"TreeNode",
		 		widgetId:field + "_treenode",
		 		id:field + "_treenode",
		 		title:field,
		 		isFolder:false,
		 		//childIconSrc:"icons/" + info.modifier + ".png"
		 	};	
		}
		else if (info.kind=="Method")
		{
			var method = info.name;
			
			/*var parameters = info.parameterList;
			for (var i=0;i<parameters.length;i++)
			{
				
			}*/
			
			properties = {
		 		dojoType:"TreeNode",
		 		widgetId:method + "_treenode",
		 		id:method + "_treenode",
		 		title:method,
		 		isFolder:false,
		 		//childIconSrc:"icons/" + info.modifier + ".png"
		 	};	
		}

		var treeNode = dojo.widget.createWidget("TreeNode", properties);
	 	parentNode.addChild(treeNode);
	}
}


/* process up or down operation */
function moveClicked(selectedNode, controllerId, icon, direction) {
	if (selectedNode.actionIsDisabled(selectedNode.actions.MOVE)) {
		return false;
	}

	this.icon = icon;
	this.oldIconSrc = icon.src;

	this.controller = dojo.widget.manager.getWidgetById(controllerId);

	if (!selectedNode) {
		alert('No node selected');
		return false;
	}

	if (direction == 'up') {
		if (!selectedNode.getPreviousSibling()) return;
		var res = controller.move(selectedNode, selectedNode.parent, selectedNode.getParentIndex()-1);
	} else if (direction == 'down') {
		if (!selectedNode.getNextSibling()) return;
		var res = controller.move(selectedNode, selectedNode.parent, selectedNode.getParentIndex()+1);
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

function removeClicked(selectedNode, controllerId, icon) {

	if (!selectedNode) {
		alert('No node selected');
		return false;
	}

	if (selectedNode.actionIsDisabled(selectedNode.actions.REMOVE)) {
		return false;
	}

	this.icon = icon;
	this.oldIconSrc = icon.src;

	this.controller = dojo.widget.manager.getWidgetById(controllerId);


	this.icon.src = '../icons/loading.jpg';

	var res = controller.removeNode(selectedNode, dojo.lang.hitch(this, restoreIconSrc));

	// local checks failed
	if (res == false) {
		restoreIconSrc.apply(this);
	}

}

var reporter = function(reporter) {
	this.name = eventName;
	this.go = function(message) {
		var rep = [ reporter + " -- event: "+this.name ];
		for(i in message) rep.push(i+": "+message[i]);
		dojo.debug(rep.join(', '));
	}
}

dojo.addOnLoad(function(){

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
		function (menuItem) { removeClicked( menuItem.getTreeNode(), 'treeController',  menuItem.getTreeNode().expandIcon); }
	);

	dojo.event.topic.subscribe('treeContextMenuUp/engage',
		function (menuItem) { moveClicked( menuItem.getTreeNode(), 'treeController',  menuItem.getTreeNode().expandIcon, 'up'); }
	);

	dojo.event.topic.subscribe('treeContextMenuDown/engage',
		function (menuItem) { moveClicked( menuItem.getTreeNode(), 'treeController',  menuItem.getTreeNode().expandIcon, 'down'); }
	);

});



