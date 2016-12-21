package graph;

import ds.GraphAdjList;

/**
 * Given a directed graph, check whether the graph contains a cycle or not.
 * 
 * Link: http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 * 
 * @author shivam.maharshi
 */
public class DetectCycleInDirectedGraph {

	// O(E+V)
	public static boolean isCyclic(GraphAdjList graph) {
		boolean[] visited = new boolean[graph.size()];
		return isCyclic(graph, 0, visited);
	}

	private static boolean isCyclic(GraphAdjList graph, int v, boolean[] visited) {
		if (visited[v])
			return true;
		visited[v] = true;
		for (int i = 0; i < graph.getAdjList(v).size(); i++) {
			if (isCyclic(graph, graph.getAdjList(v).get(i), visited))
				return true;
			else
				visited[graph.getAdjList(v).get(i)] = false; // Backtrack.
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isCyclic(GraphAdjList.getPopulatedCyclicDirectedGraph()));
		System.out.println(isCyclic(GraphAdjList.getPopulatedNonCyclicDirectedGraph()));
	}

}
