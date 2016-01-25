package graph;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a Weighted Directed Acyclic Graph (DAG) and a source vertex s in it,
 * find the longest distances from s to all other vertices in the given graph.
 * 
 * Link: http://www.geeksforgeeks.org/find-longest-path-directed-acyclic-graph/
 * 
 * @author shivam.maharshi
 */
public class LongestPathInDirectedAcyclicGraph {

	// O(V+E)
	public static void find(int[][] graph, int v) {
		Stack<Integer> stack = TopologicalSorting.sort(graph);
		int[] dis = new int[graph.length];
		Arrays.fill(dis, Integer.MIN_VALUE);
		dis[v] = 0; // Set as source.
		while (!stack.isEmpty()) {
			int ver = stack.pop();
			if (dis[ver] != Integer.MIN_VALUE) {
				for (int i = 0; i < graph.length; i++) {
					if (graph[ver][i] != 0) {
						if (dis[i] < graph[ver][i] + dis[ver]) {
							dis[i] = graph[ver][i] + dis[ver];
						}
					}
				}
			}
		}
		for (int d : dis)
			System.out.print(d + " ");
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 5, 3, 0, 0, 0 }, { 0, 0, 2, 6, 0, 0 }, { 0, 0, 0, 7, 4, 2 }, { 0, 0, 0, 0, -1, 1 },
				{ 0, 0, 0, 0, 0, -2 }, { 0, 0, 0, 0, 0, 0 } };
		find(graph, 1);
	}

}
