package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

// Java program to Clone an Undirected Graph
// graph.GraphNode class represents each
// Node of the Graph
class GraphNode {

    int val;

    // A neighbour Vector which contains references to
    // all the neighbours of a graph.GraphNode
    Vector<GraphNode> neighbours;

    public GraphNode(int val) {
        this.val = val;
        neighbours = new Vector<GraphNode>();
    }
}

class GraphCloneAGraph {

    // A method which clones the graph and
    // returns the reference of new cloned source node
    public GraphNode cloneGraph(GraphNode source) {

        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.add(source);
        // An HashMap to keep track of all the nodes which have already been created
        HashMap<GraphNode, GraphNode> map = new HashMap<GraphNode, GraphNode>();
        //Put the node into the HashMap
        map.put(source, new GraphNode(source.val));

        while (!queue.isEmpty()) {
            // Get the front node from the queue and then visit all its neighbours
            GraphNode frontNode = queue.poll();
            // Get corresponding Cloned Graph Node
            GraphNode cloneNodeU = map.get(frontNode);
            if (frontNode.neighbours != null) {
                Vector<GraphNode> neighboursVector = frontNode.neighbours;
                for (GraphNode graphNode : neighboursVector) {
                    // Get the corresponding cloned node
                    // If the node is not cloned then we will simply get a null
                    GraphNode checkClonedGraphNode = map.get(graphNode);
                    // Check if this node has already been created
                    if (checkClonedGraphNode == null) {
                        queue.add(graphNode);
                        // If not then create a new Node and
                        // put into the HashMap
                        checkClonedGraphNode = new GraphNode(graphNode.val);
                        map.put(graphNode, checkClonedGraphNode);
                    }
                    // add the 'cloneNodeG' to neighbour
                    // vector of the cloneNodeG
                    cloneNodeU.neighbours.add(checkClonedGraphNode);
                }
            }
        }

        // Return the reference of cloned source Node
        return map.get(source);
    }

    // Build the desired graph
    public GraphNode buildGraph() {
		/*
			Note : All the edges are Undirected
			Given Graph:
			1--2
			| |
			4--3
		*/
        GraphNode node1 = new GraphNode(1);
        GraphNode node2 = new GraphNode(2);
        GraphNode node3 = new GraphNode(3);
        GraphNode node4 = new GraphNode(4);
        Vector<GraphNode> v = new Vector<GraphNode>();
        v.add(node2);
        v.add(node4);
        node1.neighbours = v;
        v = new Vector<GraphNode>();
        v.add(node1);
        v.add(node3);
        node2.neighbours = v;
        v = new Vector<GraphNode>();
        v.add(node2);
        v.add(node4);
        node3.neighbours = v;
        v = new Vector<GraphNode>();
        v.add(node3);
        v.add(node1);
        node4.neighbours = v;
        return node1;
    }

    // BFS traversal of a graph to
    // check if the cloned graph is correct
    public void bfs(GraphNode source) {
        Queue<GraphNode> q = new LinkedList<GraphNode>();
        q.add(source);
        HashMap<GraphNode, Boolean> visit =
            new HashMap<GraphNode, Boolean>();
        visit.put(source, true);
        while (!q.isEmpty()) {
            GraphNode u = q.poll();
            System.out.println("Value of Node " + u.val);
            System.out.println("Address of Node " + u);
            if (u.neighbours != null) {
                Vector<GraphNode> v = u.neighbours;
                for (GraphNode g : v) {
                    if (visit.get(g) == null) {
                        q.add(g);
                        visit.put(g, true);
                    }
                }
            }
        }
        System.out.println();
    }
}

// Driver code
class Main {

    public static void main(String[] args) {
        GraphCloneAGraph graph = new GraphCloneAGraph();
        GraphNode source = graph.buildGraph();
        System.out.println("BFS traversal of a graph before cloning");
        graph.bfs(source);
        GraphNode newSource = graph.cloneGraph(source);
        System.out.println("BFS traversal of a graph after cloning");
        graph.bfs(newSource);
    }
}
