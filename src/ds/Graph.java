package ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Standard representation of a Graph.
 * 
 * @author shivam.maharshi
 */
public class Graph {

	List<Node> nodes;
	List<Edge> edges;

	public Graph() {
	}

	public Graph(List<Node> nodes, List<Edge> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}

	public void addNode(Node node) {
		if (nodes == null)
			nodes = new ArrayList<>();
		nodes.add(node);
	}

	public void addEdge(Edge edge) {
		if (edges == null)
			edges = new ArrayList<>();
		edges.add(edge);
	}

	public int size() {
		return nodes == null ? 0 : nodes.size();
	}

	public Set<Node> getAdjNodes(Node node) {
		Set<Node> adjNodes = new TreeSet<>();
		for (Edge edge : edges) {
			if (edge.src == node.getId()) {
				adjNodes.add(getNode(edge.des));
			} else if (edge.des == node.getId()) {
				adjNodes.add(getNode(edge.src));
			}
		}
		return adjNodes;
	}

	public Set<Edge> getEdges(Node node) {
		Set<Edge> connectedEdges = new TreeSet<>();
		for (Edge edge : edges) {
			if (edge.src == node.getId() || edge.des == node.getId()) {
				connectedEdges.add(edge);
			}
		}
		return connectedEdges;
	}

	public Node getNode(int id) {
		for (Node node : nodes) {
			if (node.getId() == id)
				return node;
		}
		return null;
	}

	public boolean isNodePresent(int id) {
		for (Node node : nodes) {
			if (node.getId() == id)
				return true;
		}
		return false;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

}