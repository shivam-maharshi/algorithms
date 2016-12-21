package graph;

import java.util.Stack;

/**
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of
 * vertices such that for every directed edge uv, vertex u comes before v in the
 * ordering. Topological Sorting for a graph is not possible if the graph is not
 * a DAG. This is because for TS there must be 1. At least one node that has in
 * order of 0 i.e. no nodes are directed towards it. 2. There must be at least
 * one node that has out order of 0 i.e. it does not direct to any other node.
 * 
 * Link: http://www.geeksforgeeks.org/topological-sorting/
 * 
 * @author shivam.maharshi
 */
public class TopologicalSorting {

	// Complexity is O(V+E)
	public static Stack<Integer> sort(int[][] adjList) {
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[adjList.length];
		for (int i = 0; i < adjList.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				parseGraph(adjList, i, stack, visited);
				stack.push(i);
			}
		}
		return stack;
	}

	private static void printSol(Stack<Integer> stack) {
		while (!stack.isEmpty())
			System.out.println(stack.pop() + " ");
	}

	private static void parseGraph(int[][] adjList, int v, Stack<Integer> stack, boolean[] visited) {
		for (int i = 0; i < adjList.length; i++) {
			if (!visited[i] && adjList[v][i] != 0) {
				visited[i] = true;
				parseGraph(adjList, i, stack, visited);
				stack.push(i);
			}
		}
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0 }, { 0, 1, 0, 0, 0, 0 },
				{ 1, 1, 0, 0, 0, 0 }, { 1, 0, 1, 0, 0, 0 } };
		Stack<Integer> stack = sort(graph);
		printSol(stack);
	}

}
