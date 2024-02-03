package graph;

import ds.GraphAdjList;

/**
 * Standard Depth First Search implementation for various graph representation.
 * 
 * Link: http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph
 * 
 * @author shivam.maharshi
 */
public class DepthFirstSearch {

	// O(E+V)
	public static void dfs(GraphAdjList graph, int v) {
		boolean[] visited = new boolean[graph.size()];
		dfs(graph, v, visited);
	}

	private static void dfs(GraphAdjList graph, int v, boolean[] visited) {
		if (!visited[v]) {
			System.out.print(v + " ");
			visited[v] = true;
			for (int i = 0; i < graph.getAdjList(v).size(); i++) {
				dfs(graph, graph.getAdjList(v).get(i), visited);
			}
		}
	}

	public static void main(String[] args) {
		dfs(GraphAdjList.getPopulatedCyclicDirectedGraph(), 2);
	}

}
