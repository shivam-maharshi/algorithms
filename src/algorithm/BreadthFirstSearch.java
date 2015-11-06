package algorithm;

import java.util.LinkedList;

import data.structures.Graph;
import data.structures.Node;
import data.structures.State;

public class BreadthFirstSearch {

	public static boolean isConnected(Graph graph, Node start, Node end) {
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

	public static void main(String[] args) {
		Graph graph = new Graph(Graph.getTestData());
		Node start = graph.get(1);
		Node end = graph.get(8);
		System.out.println(BreadthFirstSearch.isConnected(graph, start, end));
	}

}