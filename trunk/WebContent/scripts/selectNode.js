/**
 * @description: Select the node of tree in navigate
 * @author: zz
 * @date: 2006-9-29 
 */
function DisplayTreeContent(){
    this.update = function(message) {
        var clickedTreeNode = message.node;

		alert(clickedTreeNode);
    };
}

var displayer = new DisplayTreeContent();

var nodeSelectionTopic = dojo.event.topic.getTopic("nodeSelected");
nodeSelectionTopic.subscribe(displayer, "update");
