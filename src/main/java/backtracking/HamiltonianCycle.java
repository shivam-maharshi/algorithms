package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Hamiltonian Path in an undirected graph is a path that visits each vertex
 * exactly once. A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian
 * Path such that there is an edge (in graph) from the last vertex to the first
 * vertex of the Hamiltonian Path. Determine whether a given graph contains
 * Hamiltonian Cycle or not. If it contains, then print the path. Following are
 * the input and output of the required function.
 * 
 * Link: http://www.geeksforgeeks.org/backtracking-set-7-hamiltonian-cycle/
 * 
 * @author shivam.maharshi
 */
public class HamiltonianCycle {

	public static void path(int[][] graph) {
		List<Integer> path = new ArrayList<>();
		path.add(0);
		if (path(0, graph, new boolean[graph.length], path)) {
			printSol(path);
		} else
			System.out.println("Not possible.");
	}

	private static boolean path(int v, int[][] graph, boolean[] visited, List<Integer> list) {
		visited[v] = true;
		if (allVisited(visited)) {
			list.add(0);
			return true;
		}
		for (int i = 0; i < graph.length; i++) {
			if (!visited[i] && graph[v][i] == 1) {
				list.add(i);
				if (!path(i, graph, visited, list)) {
					visited[i] = false;
					list.remove(list.size() - 1);
				} else
					return true;
			}
		}
		return false;
	}

	private static boolean allVisited(boolean[] visited) {
		for (int i = 0; i < visited.length; i++)
			if (!visited[i])
				return false;
		return true;
	}

	private static void printSol(List<Integer> list) {
		for (int v : list)
			System.out.print(v + " ");
		System.out.println("");
	}

	public static void main(String[] args) {
		int[][] graph = new int[][] { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 }, { 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 },
				{ 0, 1, 1, 1, 0 } };
		path(graph);
	}

}
