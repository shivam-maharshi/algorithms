package graph;

import java.util.Arrays;

/**
 * Given a graph and a source vertex in graph, find shortest paths from source
 * to all vertices in the given graph.
 * 
 * Link:
 * http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-
 * algorithm/
 * 
 * @author shivam.maharshi
 */
public class DijkstraShortestPath {

	/**
	 * The code is much smaller with adjacency matrix representation of graph.
	 */
	public static void getPath(int src, int[][] graph) {
		boolean[] visited = new boolean[graph.length];
		int[] distance = new int[graph.length];
		visited[src] = true;
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[src] = 0;
		int curNode = src;
		int count = graph.length;
		while (count > 0) {
			for (int i = 0; i < graph.length; i++) {
				if (!visited[i] && graph[curNode][i] != 0 && distance[i] > graph[curNode][i] + distance[curNode]) {
					distance[i] = graph[curNode][i] + distance[curNode];
				}
			}

			curNode = getClosestNode(visited, distance);
			visited[curNode] = true;
			count--;
		}
		printSol(src, distance);
	}

	private static int getClosestNode(boolean[] visited, int[] distance) {
		int id = 0;
		int minDistance = Integer.MAX_VALUE;
		for (int i = 0; i < visited.length; i++)
			if (!visited[i] && minDistance > distance[i]) {
				id = i;
				minDistance = distance[i];
			}
		return id;
	}

	private static void printSol(int src, int[] dis) {
		for (int i = 0; i < dis.length; i++)
			System.out.println(" Shortest distance of " + src + " to " + i + " = " + dis[i]);
	}

	public static void main(String[] args) {
		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 0, 10, 0, 2, 0, 0 }, { 0, 0, 0, 14, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		getPath(0, graph);
	}

}