package data.structures;

/**
 * Standard generic representation of a Binary Search Tree.
 * 
 * @author shivam.maharshi
 */
public class BinarySearchTree<V> {

	private V value;
	private BinarySearchTree<V> left;
	private BinarySearchTree<V> right;

	public void insert(V value) {
		BinarySearchTree<V> node = this;
		while (node != null) {
//			if (false) {
//				node = node.left;
//			} else {
//				node = node.right;
//			}
		}
		if (node == null) {
			node = new BinarySearchTree<V>();
			node.value = value;
		}
	}

	public BinarySearchTree<V> createMinimalHieghtTree(V[] arr) {
		this.insertIntoNode(arr, 0, arr.length - 1);
		return this;
	}

	private void insertIntoNode(V[] arr, int low, int high) {
		while (low <= high) {
			Integer mid = (low + high) / 2;
			this.insert((V)mid);
			insertIntoNode(arr, low, mid - 1);
			insertIntoNode(arr, mid + 1, high);
		}
	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> root = new BinarySearchTree<Integer>();
		Integer[] arr = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		root.createMinimalHieghtTree(arr);
	}

}
