package data.structures;

public class BinarySearchTree {
	
	private int value;
	private BinarySearchTree left;
	private BinarySearchTree right;
	
	public void insert (int value) {
		BinarySearchTree node = this;
		while(node!=null) {
			if(node.value > value) {
				node = node.left;
			} else {
				node = node.right;
			}
		}
		if(node == null) {
			node = new BinarySearchTree();
			node.value = value;
		}
	}
	
	public BinarySearchTree createMinimalHieghtTree(int[] arr) {
		this.insertIntoNode(arr, 0, arr.length-1);
		return this;
	}
	
	private void insertIntoNode(int[] arr, int low, int high) {
		while(low <= high) {
			int mid = ( low + high ) / 2 ;
			this.insert(mid);
			insertIntoNode(arr, low, mid - 1);
			insertIntoNode(arr, mid + 1, high);
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree root = new BinarySearchTree();
		int[] arr = new int [] {1,2,3,4,5,6,7,8,9};
		root.createMinimalHieghtTree(arr);
	}

}
