/* given a binary tree, design an algorithm which creates a linked list of all the nodes
 * at each depth (e.g., if you have a tree with depth D, you'll have D linked lists) */

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeCreateLinkedListForEachLevel {
	ArrayList<LinkedList<Node>> createLinkedList(Node root) {
		ArrayList<LinkedList<Node>> result = new ArrayList<LinkedList<Node>>();
		/* "visit" the root */
		LinkedList<Node> current = new LinkedList<Node>();
		if(root != null) {
			current.add(root);
		}

		while(current.size() > 0) {
			result.add(current); //add previous level
			LinkedList<Node> parents = current; //go to next level
			current = new LinkedList<Node>();
			for(Node parent : parents) {
				/* visit the children */
				if(parent.left != null) {
					current.add(parent.left);
				}
				if(parent.right != null) {
					current.add(parent.right);
				}
			}
		}
		return result;
	}
}