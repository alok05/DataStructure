package graph;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

class Vertex {

    private String label;

    private boolean beingVisited;
    private boolean visited;

    private List<Vertex> adjacencyList;

    public Vertex(String label) {
        this.label = label;
        this.adjacencyList = new ArrayList<>();
    }

    public boolean isBeingVisited() {
        return beingVisited;
    }

    public void setBeingVisited(boolean beingVisited) {
        this.beingVisited = beingVisited;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<Vertex> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public void addNeighbor(Vertex adjacent) {
        this.adjacencyList.add(adjacent);
    }

}

class GraphDetectCycleDirected {

    private final List<Vertex> vertices;

    public GraphDetectCycleDirected() {
        this.vertices = new ArrayList<>();
    }

    public void addVertex(Vertex vertex) {
        this.vertices.add(vertex);
    }

    public void addEdge(Vertex from, Vertex to) {
        from.addNeighbor(to);
    }

    /*
    To detect a cycle in a directed graph, we'll use a variation of DFS traversal:
    Pick up an unvisited vertex v and mark its state as beingVisited
    For each neighboring vertex u of v, check:
    If u is already in the beingVisited state, it clearly means there exists a backward edge and so a cycle has been detected
    If u is yet in an unvisited state, we'll recursively visit u in a depth-first manner
    Update the vertex v‘s beingVisited flag to false and its visited flag to true
    Note that all the vertices of our graph are initially in an unvisited state as both their beingVisited and visited flags are initialized with false.
    * */
    public boolean hasCycle(Vertex sourceVertex) {
        sourceVertex.setBeingVisited(true);

        for (Vertex neighbor : sourceVertex.getAdjacencyList()) {
            if (neighbor.isBeingVisited()) {
                // backward edge exists
                return true;
            } else if (!neighbor.isVisited() && hasCycle(neighbor)) {
                return true;
            }
        }
        sourceVertex.setBeingVisited(false);
        sourceVertex.setVisited(true);
        return false;
    }
    //disconnected graph
    public boolean hasCycle() {
        for (Vertex vertex : vertices) {
            if (!vertex.isVisited() && hasCycle(vertex)) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void givenGraph_whenCycleExists_thenReturnTrue() {

        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");

        GraphDetectCycleDirected graph = new GraphDetectCycleDirected();
        graph.addVertex(vertexA);
        graph.addVertex(vertexB);
        graph.addVertex(vertexC);
        graph.addVertex(vertexD);

        graph.addEdge(vertexA, vertexB);
        graph.addEdge(vertexB, vertexC);
        graph.addEdge(vertexC, vertexA);
        graph.addEdge(vertexD, vertexC);

        assertTrue(graph.hasCycle());
    }
}
