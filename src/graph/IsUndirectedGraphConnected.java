package graph;

import data.structures.GraphAdjList;

/**
 * Check if the undirected graph is connected, which means that every node can
 * be reached from any other node.
 * 
 * @author shivam.maharshi
 */
public class IsUndirectedGraphConnected {

	// Will follow the DFS approach.
	public static boolean isConnected(GraphAdjList graph) {
		boolean[] visited = new boolean[graph.size()];
		dfs(graph, 0, visited);
		for (boolean v : visited)
			if (!v)
				return false;
		return true;
	}

	private static void dfs(GraphAdjList graph, int v, boolean[] visited) {
		if (!visited[v]) {
			visited[v] = true;
			for (int i = 0; i < graph.getAdjList(v).size(); i++) {
				dfs(graph, graph.getAdjList(v).get(i), visited);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(isConnected(GraphAdjList.getPopulatedCyclicUndirectedGraph()));
		System.out.println(isConnected(GraphAdjList.getPopulatedNonCyclicUndirectedGraph()));
	}

}
