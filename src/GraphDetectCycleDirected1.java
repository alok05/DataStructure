// A Java Program to detect cycle in a graph
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class GraphDetectCycleDirected1 {
	
	private final int V;
	private final List<List<Integer>> adj;

	public GraphDetectCycleDirected1(int V)
	{
		this.V = V;
		adj = new ArrayList<>(V);
		
		for (int i = 0; i < V; i++)
			adj.add(new LinkedList<>());
	}
  /*
  * Algorithm:
  Create the graph using the given number of edges and vertices.
  Create a recursive function that initializes the current index or vertex, visited, and recursion
  stack.
  Mark the current node as visited and also mark the index in recursion stack.
  Find all the vertices which are not visited and are adjacent to the current node. Recursively call
  the function for those vertices, If the recursive function returns true, return true.
  If the adjacent vertices are already marked in the recursion stack then return true.
  Create a wrapper class, that calls the recursive function for all the vertices and if any function
  returns true return true. Else if for all vertices the function returns false return false.
  * */
  //	Complexity Analysis:
  //	Time Complexity: O(V+E).
  //	Time Complexity of this method is same as time complexity of DFS traversal which is O(V+E).
  //	Space Complexity: O(V).
  //	To store the visited and recursion stack O(V) space is needed.
	private boolean isCyclicUtil(int i, boolean[] visited,
									boolean[] recStack)
	{
		
		// Mark the current node as visited and
		// part of recursion stack
		if (recStack[i])
			return true;

		if (visited[i])
			return false;
			
		visited[i] = true;

		recStack[i] = true;
		List<Integer> children = adj.get(i);
		
		for (Integer c: children)
			if (isCyclicUtil(c, visited, recStack))
				return true;
				
		recStack[i] = false;

		return false;
	}

	private void addEdge(int source, int dest) {
		adj.get(source).add(dest);
	}

	// Returns true if the graph contains a
	// cycle, else false.
	// This function is a variation of DFS() in
	// https://www.geeksforgeeks.org/archives/18212
	private boolean isCyclic()
	{
		
		// Mark all the vertices as not visited and
		// not part of recursion stack
		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];
		
		
		// Call the recursive helper function to
		// detect cycle in different DFS trees
		for (int i = 0; i < V; i++)
			if (isCyclicUtil(i, visited, recStack))
				return true;

		return false;
	}

	// Driver code
	public static void main(String[] args)
	{
		GraphDetectCycleDirected1 graphDetectCycleDirected1 = new GraphDetectCycleDirected1(4);
		graphDetectCycleDirected1.addEdge(0, 1);
		graphDetectCycleDirected1.addEdge(0, 2);
		graphDetectCycleDirected1.addEdge(1, 2);
		graphDetectCycleDirected1.addEdge(2, 0);
		graphDetectCycleDirected1.addEdge(2, 3);
		graphDetectCycleDirected1.addEdge(3, 3);
		
		if(graphDetectCycleDirected1.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't "
									+ "contain cycle");
	}
}
