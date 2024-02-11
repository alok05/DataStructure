package graph;// A Java Program to detect cycle in an undirected graph

import java.util.Iterator;
import java.util.LinkedList;

// This class represents a
// directed graph using adjacency list
// representation
class GraphDetectCycleUndirected {

    // No. of vertices
    private final int V;
    // Adjacency List Representation
    private final LinkedList<Integer>[] adj;
    // Constructor
    GraphDetectCycleUndirected(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }
    // Function to add an edge
    // into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    // A recursive function that
    // uses visited[] and parent to detect
    // cycle in subgraph reachable
    // from vertex v.
    //	Time Complexity: O(V+E).
    //	The program does a simple DFS Traversal of the graph which is represented using adjacency list. So the time complexity is O(V+E).
    //	Space Complexity: O(V).
    //	To store the visited array O(V) space is required.
    Boolean isCyclicUtil(int v, Boolean[] visited,
        int parent) {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;

        // Recur for all the vertices
        // adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();

            // If an adjacent is not
            // visited, then recur for that
            // adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v)) {
                    return true;
                }
            }

            // If an adjacent is visited
            // and not parent of current
            // vertex, then there is a cycle.
            else if (i != parent) {
                return true;
            }
        }
        return false;
    }

    // Returns true if the graph
    // contains a cycle, else false.
    Boolean isCyclic() {

        // Mark all the vertices as
        // not visited and not part of
        // recursion stack
        Boolean[] visited = new Boolean[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
        }

        // Call the recursive helper
        // function to detect cycle in
        // different DFS trees
        for (int u = 0; u < V; u++) {

            // Don't recur for u if already visited
            if (!visited[u]) {
                if (isCyclicUtil(u, visited, -1)) {
                    return true;
                }
            }
        }

        return false;
    }
    // Driver method to test above methods
    public static void main(String[] args) {

        // Create a graph given
        // in the above diagram
        GraphDetectCycleUndirected g1 = new GraphDetectCycleUndirected(5);
        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 1);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);
        if (g1.isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contains cycle");
        }

        GraphDetectCycleUndirected g2 = new GraphDetectCycleUndirected(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        if (g2.isCyclic()) {
            System.out.println("Graph contains cycle");
        } else {
            System.out.println("Graph doesn't contains cycle");
        }
    }
}
