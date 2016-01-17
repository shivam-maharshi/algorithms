package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import data.structures.Edge;
import data.structures.Graph;
import data.structures.Node;
import data.structures.Union;

/**
 * Create a minimum spanning tree for the given graph using Kruskal's algorithm.
 * 
 * Link: http://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-
 * spanning-tree-mst/
 * 
 * @author shivam.maharshi
 */
public class KruskalMinimumSpanningTree {

	public static List<Edge> constructMST(Graph g) {
		List<Edge> mst = new ArrayList<>();
		List<Edge> edges = g.getEdges();
		Collections.sort(edges, new WieghtComp());
		Union u = new Union(g.getNodes().size());
		for (Edge e : edges) {
			if (!u.isConnected(e.getDes(), e.getSrc())) {
				u.connect(e.getDes(), e.getSrc());
				mst.add(e);
			}
		}
		return mst;
	}

	public static void main(String[] args) {
		List<Edge> e = new ArrayList<Edge>();
		e.add(new Edge(0, 7, 8));
		e.add(new Edge(0, 1, 4));
		e.add(new Edge(1, 7, 11));
		e.add(new Edge(1, 2, 8));
		e.add(new Edge(7, 6, 1));
		e.add(new Edge(7, 8, 7));
		e.add(new Edge(2, 8, 2));
		e.add(new Edge(6, 8, 6));
		e.add(new Edge(6, 5, 2));
		e.add(new Edge(2, 5, 4));
		e.add(new Edge(2, 3, 7));
		e.add(new Edge(3, 5, 14));
		e.add(new Edge(3, 4, 9));
		e.add(new Edge(5, 4, 10));

		List<Node> nodes = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			nodes.add(new Node(i));
		}
		Graph g = new Graph(nodes, e);
		List<Edge> mst = KruskalMinimumSpanningTree.constructMST(g);
		for (Edge edges : mst) {
			System.out.println(edges);
		}
	}

}

class WieghtComp implements Comparator<Edge> {

	@Override
	public int compare(Edge o1, Edge o2) {
		return o1.getWieght() < o2.getWieght() ? -1 : 1;
	}

}