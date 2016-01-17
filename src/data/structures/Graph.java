package data.structures;

import java.util.List;

/**
 * Standard representation of a Graph.
 * 
 * @author shivam.maharshi
 */
public class Graph {

	List<Node> nodes;
	List<Edge> edges;

	public Graph(List<Node> nodes, List<Edge> edges) {
		this.nodes = nodes;
		this.edges = edges;
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