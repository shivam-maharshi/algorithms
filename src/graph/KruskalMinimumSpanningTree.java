package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Link: http://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
 * 
 * @author shivam.maharshi
 *
 */
public class KruskalMinimumSpanningTree {

	public static List<Edge> constructMST(Graph g) {
		List<Edge> mst = new ArrayList<>();
		List<Edge> edges = g.edges;
		Collections.sort(edges, new WieghtComp());
		Union u = new Union(g.nodes.size());
		for (Edge e : edges) {
			if (!u.isConnected(e.des, e.src)) {
				u.connect(e.des, e.src);
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

class Union {
	int[] a;

	public Union(int n) {
		a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = i;
		}
	}

	public boolean isConnected(int n1, int n2) {
		return getParent(n1) == getParent(n2);
	}

	public void connect(int n1, int n2) {
		int p1 = getParent(n1);
		int p2 = getParent(n2);
		int pMin = Math.min(p1, p2);
		int pMax = Math.max(p1, p2);
		for (int i = 0; i < a.length; i++) {
			if (a[i] == pMax) {
				a[i] = pMin;
			}
		}
	}

	private int getParent(int id) {
		return a[id];
	}
}

class WieghtComp implements Comparator<Edge> {

	@Override
	public int compare(Edge o1, Edge o2) {
		return o1.wieght < o2.wieght ? -1 : 1;
	}

}

class Graph {

	List<Node> nodes;
	List<Edge> edges;

	public Graph(List<Node> nodes, List<Edge> edges) {
		this.nodes = nodes;
		this.edges = edges;
	}

}

class Node {
	int id;

	public Node(int id) {
		this.id = id;
	}
}

class Edge {
	int wieght;
	int src;
	int des;

	public Edge(int src, int des, int wieght) {
		this.src = src;
		this.des = des;
		this.wieght = wieght;
	}

	@Override
	public String toString() {
		return "Edge [wieght=" + wieght + ", src=" + src + ", des=" + des + "]";
	}

}