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

}