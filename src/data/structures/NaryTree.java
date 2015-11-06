package data.structures;

import java.util.List;

public class NaryTree {

	private int value;
	List<NaryTree> nodes;

	public NaryTree(int value) {
		this.value = value;
	}

	public NaryTree getParent() {
		// TODO:
		return null;
	}

	public int getDepth(NaryTree node) {
		int depth = 0;
		NaryTree root = this;
		while (root != node) {
			for (int i = 0; i < nodes.size(); i++) {
				depth = getDepth(nodes.get(i)) + 1;
			}
		}
		return depth;
	}

	/*
	 * Logic: Bring the deeper node to the same level. Move both nodes up till
	 * they are the same.
	 */
	public NaryTree getLowestCommonAncestor(NaryTree n1, NaryTree n2) {
		int n1Depth = getDepth(n1);
		int n2Depth = getDepth(n2);
		if (n1Depth > n2Depth) {
			for (int i = 0; i < n1Depth - n2Depth; i++) {
				n1 = n1.getParent();
			}
		} else {
			for (int i = 0; i < n2Depth - n1Depth; i++) {
				n2 = n2.getParent();
			}
		}
		while (n1 != n2) {
			n1 = n1.getParent();
			n2 = n2.getParent();
		}
		return n1;
	}

}
