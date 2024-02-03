package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n cities and distances between every pair of cities, select k cities to
 * place warehouses (or ATMs) such that the maximum distance of a city to a
 * warehouse (or ATM) is minimized.
 * 
 * Link:
 * http://www.geeksforgeeks.org/k-centers-problem-set-1-greedy-approximate-algorithm
 * 
 * @author shivam.maharshi
 */
public class KCenterProblem {

	/*
	 * The fundamental is very interesting. Add zero node to the added set. Then
	 * find another node which is farthest from the nodes present in this set.
	 * Add this node to the Added Set and repeat the process. A node is
	 * considered farthest from a set when its minimum distance from all the
	 * nodes present in this set is maximum as compared to the other nodes.
	 * Min[dist(p, c1), dist(p, c2), dist(p, c3). dist(p, ci)]
	 */
	public static void solve(int[][] graph, int k) {
		boolean[] added = new boolean[graph.length];
		List<Integer> nodes = new ArrayList<>();
		added[0] = true;
		nodes.add(0);
		while (nodes.size() != k) {
			int maxDisFromNode = Integer.MIN_VALUE;
			int maxDisNodeToBeAdded = 0;
			for (Integer node : nodes) {
				int minDisFromNode = Integer.MAX_VALUE;
				int minDisNodeToBeAdded = 0;
				for (int i = 0; i < graph.length; i++) {
					if (!added[i] && graph[node][i] != 0 && graph[node][i] < minDisFromNode) {
						minDisFromNode = graph[node][i];
						minDisNodeToBeAdded = i;
					}
				}
				if (minDisFromNode > maxDisFromNode) {
					maxDisFromNode = minDisFromNode;
					maxDisNodeToBeAdded = minDisNodeToBeAdded;
				}
			}
			added[maxDisNodeToBeAdded] = true;
			nodes.add(maxDisNodeToBeAdded);
		}
		for (Integer n : nodes)
			System.out.print(n + " ");
	}

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 10, 7, 6 }, { 10, 0, 8, 5 }, { 7, 8, 0, 12 }, { 6, 5, 12, 0 } };
		solve(graph, 2);
	}

}
