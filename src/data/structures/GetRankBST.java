package data.structures;

/**
 * Design a data structure using which we can calculate rank of a number very
 * fast.
 * 
 * @author shivam.maharshi
 */
public class GetRankBST {

	GetRankBST left;
	GetRankBST right;
	int value;
	int childCount;

	public GetRankBST(int value) {
		this.value = value;
		this.childCount = 0;
	}

	public void insert(GetRankBST root, int value) {
		while (true) {
			if (value > root.value) {
				root.childCount++;
				if (root.right == null) {
					root.right = new GetRankBST(value);
				} else {
					insert(root.right, value);
				}
				return;
			} else {
				root.childCount++;
				if (root.left == null) {
					root.left = new GetRankBST(value);
				} else {
					insert(root.left, value);
				}
				return;
			}
		}
	}

	public int getRank(GetRankBST root, int value) {
		if (root == null) {
			// Not present.
			return -1;
		}
		if (root.value == value)
			return getChildCount(root.left) + 2;
		if (value < root.value) {
			return getRank(root.left, value);
		} else {
			return getChildCount(root.left) + getRank(root.right, value);
		}
	}

	public int getChildCount(GetRankBST node) {
		if (node == null)
			return -1;
		return node.childCount;
	}

	public static void main(String[] args) {
		GetRankBST root = new GetRankBST(100);
		root.insert(root, 50);
		System.out.println(root.getRank(root, 50));
	}

}
