package graph;

import java.util.LinkedList;
import java.util.Queue;

import data.structures.GraphAdjList;
import data.structures.GraphComplex;
import data.structures.Node;
import data.structures.State;

/**
 * Standard Breadth First Search implementation.
 * 
 * Link: http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 * 
 * @author shivam.maharshi
 */
public class BreadthFirstSearch {

	public static boolean isConnected(GraphComplex graph, Node start, Node end) {
		LinkedList<Node> queue = new LinkedList<Node>();

		for (int i = 1; i <= graph.size(); i++) {
			graph.get(i).setState(State.UNVISITED);
		}

		queue.add(start);
		start.setState(State.VISITING);
		Node node;

		while (!queue.isEmpty()) {
			node = queue.removeFirst();
			for (Node adjNode : node.getAdjNodes()) {
				if (adjNode.getState() == State.UNVISITED) {
					if (adjNode == end) {
						return true;
					} else {
						adjNode.setState(State.VISITING);
						queue.add(adjNode);
					}
				}
			}
			node.setState(State.VISITED);
		}
		return false;
	}

	// BFS method for Graph in Adjacency List Representation.
	public static void bfs(GraphAdjList graph, int v) {
		boolean[] visited = new boolean[graph.size()];
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		while (!q.isEmpty()) {
			int ver = q.poll();
			visited[ver] = true;
			System.out.print(ver + " ");
			LinkedList<Integer> adjNodes = graph.getAdjList(ver);
			for (int i = 0; i < adjNodes.size(); i++) {
				if (!visited[adjNodes.get(i)]) {
					q.add(adjNodes.get(i));
				}
			}
		}
	}

	public static void main(String[] args) {
		 GraphComplex g = GraphComplex.getPopulatedGraph();
		 Node start = g.get(1);
		 Node end = g.get(8);
		 System.out.println(BreadthFirstSearch.isConnected(g, start, end));
		bfs(GraphAdjList.getPopulatedCyclicGraph(), 2);
	}

}