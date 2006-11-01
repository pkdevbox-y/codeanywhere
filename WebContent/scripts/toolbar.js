/**
 * @description: Load the function of toolbar
 * @author: zz
 * @date: 2006-9-28
 */

dojo.addOnLoad(function(){
	dojo.event.connect(dojo.widget.byId("newTreeNode"), "onClick", function() {
		createClicked(dojo.widget.manager.getWidgetById('treeSelector').selectedNode,'treeController', this);
	});
	
	dojo.event.connect(dojo.widget.byId("moveUp"), "onClick", function() {
		moveClicked(dojo.widget.manager.getWidgetById('treeSelector').selectedNode,'treeController', this, 'up');
	});
	
	dojo.event.connect(dojo.widget.byId("moveDown"), "onClick", function() {
		moveClicked(dojo.widget.manager.getWidgetById('treeSelector').selectedNode,'treeController', this, 'down');
	});
	
	dojo.event.connect(dojo.widget.byId("deleteTreeNode"), "onClick", function() {
		removeClicked(dojo.widget.manager.getWidgetById('treeSelector').selectedNode, 'treeController', this);
	});
	
	//dojo.event.connect(dojo.widget.byId("searchbutton"), "onClick", search);
	
	//dojo.event.connect(dojo.widget.byId("format"), "onClick", format);
	
	//dojo.event.connect(dojo.widget.byId("newclass"), "onClick", showNewClassDialog);
	
	//dojo.event.connect(dojo.widget.byId("run"), "onClick", compile);
	
});
