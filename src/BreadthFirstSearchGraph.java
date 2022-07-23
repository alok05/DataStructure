// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.

import java.util.Iterator;
import java.util.LinkedList;

// This class represents a directed graph using adjacency list
// representation
class BreadthFirstSearchGraph {

    private final int V; // No. of vertices
    private final LinkedList<Integer>[] adj; //Adjacency Lists
    // Constructor
    BreadthFirstSearchGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }
    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // prints BFS traversal from a given source s
    //  Time Complexity: O(V+E), where V is the number of nodes and E is the number of edges.
    //  Auxiliary Space: O(V)
    void BFS(int srch) {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean[] visited = new boolean[V];
        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
        // Mark the current node as visited and enqueue it
        visited[srch] = true;
        queue.add(srch);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            srch = queue.poll();
            System.out.print(srch + " ");
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[srch].listIterator();

            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
    // Driver method to
    public static void main(String[] args) {
        BreadthFirstSearchGraph g = new BreadthFirstSearchGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
            "(starting from vertex 2)");

        g.BFS(2);
    }
}
