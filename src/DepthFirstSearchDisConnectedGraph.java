// Java program to print DFS
// traversal from a given given
// graph

import java.util.Iterator;
import java.util.LinkedList;

// This class represents a
// directed graph using adjacency
// list representation
class DepthFirstSearchDisConnectedGraph {

    private final int V; // No. of vertices
    // Array of lists for
    // Adjacency List Representation
    private final LinkedList<Integer>[] adj;
    // Constructor
    @SuppressWarnings("unchecked")
    DepthFirstSearchDisConnectedGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }
    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }
    // A function used by DFS
    /*
    Create a recursive function that takes the index of the node and a visited array.
    Mark the current node as visited and print the node.
    Traverse all the adjacent and unmarked nodes and call the recursive function with the index of the
    adjacent node.
    Run a loop from 0 to the number of vertices and check if the node is unvisited in the previous DFS,
    call the recursive function with the current node.
    Time complexity: O(V + E), where V is the number of vertices and E is the number of edges in the
    graph.
    Space Complexity: O(V), since an extra visited array of size V is required.
    * */
    void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");
        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n]) {
                DFSUtil(n, visited);
            }
        }
    }
    // The function to do DFS traversal. It uses recursive
    // DFSUtil()
    void DFS() {
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean[] visited = new boolean[V];
        // Call the recursive helper function to print DFS
        // traversal starting from all vertices one by one
        for (int i = 0; i < V; ++i) {
            if (visited[i] == false) {
                DFSUtil(i, visited);
            }
        }
    }
    // Driver Code
    public static void main(String[] args) {
        DepthFirstSearchDisConnectedGraph g = new DepthFirstSearchDisConnectedGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
            "Following is Depth First Traversal");

        g.DFS();
    }
}
