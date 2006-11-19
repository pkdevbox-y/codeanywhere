/**
 * @description: Select the node of tree in navigate
 * @author: zz
 * @date: 2006-9-29 
 */
var selectedNode;

function selectNode(){
    this.update = function(message) {
        var clickedTreeNode = message.node;
		selectedNode = clickedTreeNode;
    };
}

var displayer = new selectNode();

var nodeSelectionTopic = dojo.event.topic.getTopic("nodeSelected");
nodeSelectionTopic.subscribe(displayer, "update");
