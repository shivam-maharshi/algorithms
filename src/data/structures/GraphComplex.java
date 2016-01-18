package data.structures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * A representation of graph more efficient and easy to work with.
 * 
 * @author shivam.maharshi
 */
public class GraphComplex {

	private Map<Integer, Node> graph = new HashMap<Integer, Node>();

	// Constructor of graph.
	public GraphComplex(Map<Integer, List<Integer>> adjacencyMap) {

		if (adjacencyMap != null && !adjacencyMap.isEmpty()) {
			for (Entry<Integer, List<Integer>> entry : adjacencyMap.entrySet()) {
				int id = entry.getKey();
				Node node = new Node(id);
				graph.put(id, node);
			}

			for (Entry<Integer, List<Integer>> entry : adjacencyMap.entrySet()) {
				int nodeId = entry.getKey();
				List<Integer> adjIdList = entry.getValue();
				if (adjIdList != null) {
					Node node = graph.get(nodeId);
					for (int adjId : adjIdList) {
						Node adjNode = graph.get(adjId);
						if (node.getAdjNodes() == null) {
							node.setAdjNodes(new ArrayList<Node>());
						}
						node.getAdjNodes().add(adjNode);
					}
				}
			}
		}
	}

	public int size() {
		return this.graph.size();
	}

	public Node get(int i) {
		return graph.get(i);
	}

	/*
	 * Specific functionalities.
	 */

	// Are two nodes connected.
	public boolean isConnected(int id1, int id2) {
		return getDistance(id1, id2) == -1 ? false : true;
	}

	// Get distance between two nodes.
	public int getDistance(int id1, int id2) {
		Node startNode = graph.get(id1);
		return searchNodeBfs(startNode, id2);
	}

	// Using breadth first search for shortest distance.
	private int searchNodeBfs(Node start, int id) {
		int level = 0;
		List<List<Node>> nodeLevelList = new ArrayList<List<Node>>();
		ArrayList<Node> nodeList = new ArrayList<Node>();
		nodeList.add(start);
		nodeLevelList.add(nodeList);
		while (true) {
			level++;
			nodeList = new ArrayList<>();
			for (Node node : nodeLevelList.get(level - 1)) {
				for (Node adjNode : node.getAdjNodes()) {
					if (adjNode.getState() == State.UNVISITED) {
						adjNode.setState(State.VISITED);
						adjNode.setLevel(level);
						if (adjNode.getId() == id) {
							return level;
						} else {
							nodeList.add(adjNode);
						}
					}
				}
			}
			nodeLevelList.add(nodeList);
		}
	}

	// Get specific node.
	public Node getNode(int id) {
		return graph.get(id);
	}

	// Utility method.
	public static List<Integer> getList(Integer... values) {
		List<Integer> list = new ArrayList<Integer>();
		for (Integer value : values) {
			list.add(value);
		}
		return list;
	}

	// Utility method.
	public static Map<Integer, List<Integer>> getTestData() {
		Map<Integer, List<Integer>> adjacencyMap = new HashMap<Integer, List<Integer>>();
		adjacencyMap.put(1, getList(2, 5));
		adjacencyMap.put(2, getList(1, 3, 4, 5));
		adjacencyMap.put(3, getList(2, 5, 6));
		adjacencyMap.put(4, getList(2));
		adjacencyMap.put(5, getList(1, 2, 3, 6, 7));
		adjacencyMap.put(6, getList(3, 5, 8));
		adjacencyMap.put(7, getList(5));
		adjacencyMap.put(8, getList(6));
		return adjacencyMap;
	}

	public static void main(String[] args) {
		GraphComplex graph = new GraphComplex(getTestData());
		int id1 = 1, id2 = 8;
		System.out.println("Distance between nodes : " + graph.getDistance(id1, id2));
		// System.out.println("Are nodes connected : " + graph.isConnected(id1,
		// id2));
	}

}
