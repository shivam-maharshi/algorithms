package graph;

import ds.GraphAdjList;

/**
 * Given an undirected graph, check whether the graph contains a cycle or not.
 * 
 * Link: http://www.geeksforgeeks.org/detect-cycle-undirected-graph/
 * 
 * @author shivam.maharshi
 */
public class DetectCycleInUndirectedGraph {

	// O(E+V)
	public static boolean isCyclic(GraphAdjList graph) {
		boolean[] visited = new boolean[graph.size()];
		return isCyclic(graph, 0, -1, visited);
	}

	private static boolean isCyclic(GraphAdjList graph, int v, int vParent, boolean[] visited) {
		if (visited[v])
			return true;
		visited[v] = true;
		for (int i = 0; i < graph.getAdjList(v).size(); i++) {
			if (graph.getAdjList(v).get(i) != vParent && isCyclic(graph, graph.getAdjList(v).get(i), v, visited))
				return true;
			else
				visited[graph.getAdjList(v).get(i)] = false; // Backtrack.
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isCyclic(GraphAdjList.getPopulatedCyclicUndirectedGraph()));
		System.out.println(isCyclic(GraphAdjList.getPopulatedNonCyclicUndirectedGraph()));
	}

}
