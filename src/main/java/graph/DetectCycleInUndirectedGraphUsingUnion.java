package graph;

import ds.GraphAdjList;
import ds.Union;

/**
 * Detect cycle in an undirected graph via Union Find algorithm using Disjoint
 * Data Set.
 * 
 * Link: http://www.geeksforgeeks.org/union-find
 * 
 * @author shivam.maharshi
 */
public class DetectCycleInUndirectedGraphUsingUnion {

	public static boolean isCyclic(GraphAdjList graph) {
		Union u = new Union(graph.size());
		for (int i = 0; i < graph.size(); i++) {
			for (int j = 0; j < graph.getAdjList(i).size(); j++) {
				if (graph.getAdjList(i).get(j) > i) {
					/*
					 * This condition is required because of the non directed
					 * graph implied transitive property. A->B = B->A
					 */
					if (!u.isConnected(i, graph.getAdjList(i).get(j)))
						u.connect(i, graph.getAdjList(i).get(j));
					else
						return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isCyclic(GraphAdjList.getPopulatedCyclicUndirectedGraph()));
		System.out.println(isCyclic(GraphAdjList.getPopulatedNonCyclicUndirectedGraph()));
	}

}
