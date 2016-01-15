package backtracking;

/**
 * Given an undirected graph and a number m, determine if the graph can be
 * colored with at most m colors such that no two adjacent vertices of the graph
 * are colored with same color. Here coloring of a graph means assignment of
 * colors to all vertices.
 * 
 * Link: http://www.geeksforgeeks.org/backttracking-set-5-m-coloring-problem/
 * 
 * @author shivam.maharshi
 */
public class MColoringProblem {

	public static void solve(int[][] graph, int max) {
		int[] sol = new int[graph.length];
		if (solve(0, 1, graph, sol, max))
			printSol(sol);
		else
			System.out.println("Not possible.");
	}

	private static boolean solve(int index, int color, int[][] graph, int[] sol, int max) {
		if (index == sol.length - 1) {
			sol[index] = color;
			return true;
		}
		sol[index] = color;
		for (int i = 0; i < graph.length; i++) {
			if (graph[index][i] == 1 && sol[i] == 0) {
				int tempC = 1;
				while (!isValidColor(tempC, i, graph, sol)) {
					tempC++;
				}
				if (tempC <= max) {
					if (!solve(i, tempC, graph, sol, max))
						sol[i] = 0;
					else
						return true;
				}
			}
		}
		return false;
	}

	public static boolean isValidColor(int color, int index, int[][] graph, int[] sol) {
		for (int i = 0; i < graph.length; i++) {
			if (graph[index][i] == 1) {
				if (sol[i] == color)
					return false;
			}
		}
		return true;
	}

	private static void printSol(int[] sol) {
		for (int s : sol)
			System.out.print(s + " ");
	}

	public static void main(String[] args) {
		int[][] graph = new int[][] { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 1 }, { 1, 0, 1, 0 }, };
		solve(graph, 3);
	}

}
