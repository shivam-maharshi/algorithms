package ds;

import java.util.List;

/**
 * Implementation of a generic NAry Tree.
 * 
 * @author shivam.maharshi
 */
public class NaryTree<V> {

	private V value;
	private List<NaryTree<V>> nodes;

	public NaryTree(V value) {
		this.value = value;
	}

	public NaryTree<V> getParent() {
		// TODO:
		return null;
	}

	public int getDepth(NaryTree<V> node) {
		int depth = 0;
		NaryTree<V> root = this;
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
	public NaryTree<V> getLowestCommonAncestor(NaryTree<V> n1, NaryTree<V> n2) {
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

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public List<NaryTree<V>> getNodes() {
		return nodes;
	}

	public void setNodes(List<NaryTree<V>> nodes) {
		this.nodes = nodes;
	}

}
