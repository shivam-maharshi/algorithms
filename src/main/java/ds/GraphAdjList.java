package ds;

import java.util.LinkedList;

/**
 * Adjacency list representation of a graph.
 * 
 * Link: http://www.geeksforgeeks.org/graph-and-its-representations/
 * 
 * @author shivam.maharshi
 */
public class GraphAdjList {

	private LinkedList<Integer>[] adjList;

	@SuppressWarnings("unchecked")
  public GraphAdjList(int size) {
		adjList = new LinkedList[size];
		for (int i = 0; i < size; i++)
			adjList[i] = new LinkedList<>();
	}

	/*
	 * The way the data is populated, the same structure can work for both,
	 * directed and non-directed graph. For non directed graph an edge from
	 * a->b, should be added to b->a as well. For directed graph it won't.
	 */
	public void addEdge(int v1, int v2) {
		adjList[v1].add(v2);
	}

	public void removeEdge(int v1, int v2) {
		LinkedList<Integer> list = adjList[v1];
		for (int i = 0; i < list.size(); i++)
			if (list.get(i) == v2)
				list.remove(i);
	}

	public int size() {
		return adjList.length;
	}

	public LinkedList<Integer> getAdjList(int v) {
		return adjList[v];
	}

	public static GraphAdjList getPopulatedCyclicDirectedGraph() {
		GraphAdjList g = new GraphAdjList(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		return g;
	}

	public static GraphAdjList getPopulatedNonCyclicDirectedGraph() {
		GraphAdjList g = new GraphAdjList(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		return g;
	}

	public static GraphAdjList getPopulatedCyclicUndirectedGraph() {
		GraphAdjList g = new GraphAdjList(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);
		// Node from A to B implies B to A.
		g.addEdge(1, 0);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(0, 2);
		g.addEdge(3, 2);
		return g;
	}

	public static GraphAdjList getPopulatedNonCyclicUndirectedGraph() {
		GraphAdjList g = new GraphAdjList(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		g.addEdge(1, 0);
		g.addEdge(2, 0);
		g.addEdge(3, 2);
		return g;
	}

}
