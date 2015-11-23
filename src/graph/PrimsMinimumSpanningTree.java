package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Link:
 * http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-
 * tree-mst-2/
 * 
 * @author shivam.maharshi
 */
public class PrimsMinimumSpanningTree {

	public static List<Pair> constructMST(int[][] g) {
		List<Pair> mst = new ArrayList<Pair>();
		boolean[] inMst = new boolean[g.length];
		int[] key = new int[g.length];
		Arrays.fill(key, Integer.MAX_VALUE);
		key[0] = 0;
		inMst[0] = true;
		int index = 0;
		mst.add(new Pair(0, 0));
		while (mst.size() != g.length) {
			for (int i = 0; i < g[index].length; i++) {
				if (!inMst[i] && g[index][i] != 0) {
					// This tells the weight of the node.
					if (key[i] > g[index][i]) {
						key[i] = g[index][i];
					}
				}
			}

			int minId = 0;
			int minWieght = Integer.MAX_VALUE;
			for (int i = 0; i < g.length; i++) {
				if (!inMst[i] && key[i] < minWieght) {
					minId = i;
					minWieght = key[i];
				}
			}
			mst.add(new Pair(minId, minWieght));
			index = minId;
			inMst[minId] = true;
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

		List<Nodee> n = new ArrayList<Nodee>();
		n.add(new Nodee(0, new int[] { 1, 7 }, new int[] { 4, 8 }));
		n.add(new Nodee(1, new int[] { 0, 2, 7 }, new int[] { 4, 8, 11 }));
		n.add(new Nodee(2, new int[] { 1, 3, 5, 8 }, new int[] { 8, 7, 4, 2 }));
		n.add(new Nodee(3, new int[] { 2, 4, 5 }, new int[] { 7, 9, 14 }));
		n.add(new Nodee(4, new int[] { 3, 5 }, new int[] { 9, 10 }));
		n.add(new Nodee(5, new int[] { 2, 3, 4, 6 }, new int[] { 4, 14, 10, 2 }));
		n.add(new Nodee(6, new int[] { 5, 7, 8 }, new int[] { 2, 1, 6 }));
		n.add(new Nodee(7, new int[] { 0, 1, 6, 8 }, new int[] { 8, 11, 1, 7 }));
		n.add(new Nodee(8, new int[] { 2, 6, 7 }, new int[] { 2, 6, 7 }));

		int[][] adjM = new int[9][9];
		adjM[0] = new int[] { 0, 4, 0, 0, 0, 0, 0, 8, 0 };
		adjM[1] = new int[] { 4, 0, 8, 0, 0, 0, 0, 11, 0 };
		adjM[2] = new int[] { 0, 8, 0, 7, 0, 4, 0, 0, 2 };
		adjM[3] = new int[] { 0, 0, 7, 0, 9, 14, 0, 0, 0 };
		adjM[4] = new int[] { 0, 0, 0, 9, 0, 10, 0, 0, 0 };
		adjM[5] = new int[] { 0, 0, 4, 14, 10, 0, 2, 0, 0 };
		adjM[6] = new int[] { 0, 0, 0, 0, 0, 2, 0, 1, 6 };
		adjM[7] = new int[] { 8, 11, 0, 0, 0, 0, 1, 0, 7 };
		adjM[8] = new int[] { 0, 0, 2, 0, 0, 0, 6, 7, 0 };
		List<Pair> mst = PrimsMinimumSpanningTree.constructMST(adjM);
		for (Pair pair : mst) {
			System.out.println(pair);
		}
	}

}

class Pair {
	int id;
	int wieght;

	public Pair(int id, int wieght) {
		this.id = id;
		this.wieght = wieght;
	}

	@Override
	public String toString() {
		return "Pair [id=" + id + ", wieght=" + wieght + "]";
	}

}

class Nodee {

	int id;
	int[] des;
	int[] wieght;

	public Nodee(int id, int[] des, int[] wieght) {
		this.id = id;
		this.des = des;
		this.wieght = wieght;
	}

}