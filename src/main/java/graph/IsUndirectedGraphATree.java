package graph;

import ds.GraphAdjList;

/**
 * Check if the undirected graph is a tree. An undirected graph is tree if it
 * has following properties. 1) There is no cycle. 2) The graph is connected.
 * 
 * Link: http://geeksquiz.com/check-given-graph-tree/
 * 
 * @author shivam.maharshi
 */
public class IsUndirectedGraphATree {

	public static boolean isTree(GraphAdjList graph) {
		return IsUndirectedGraphConnected.isConnected(graph) && !DetectCycleInUndirectedGraph.isCyclic(graph);
	}

	public static void main(String[] args) {
		System.out.println(isTree(GraphAdjList.getPopulatedCyclicUndirectedGraph()));
		System.out.println(isTree(GraphAdjList.getPopulatedNonCyclicUndirectedGraph()));
	}

}
