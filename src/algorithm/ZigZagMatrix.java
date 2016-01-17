package algorithm;

/**
 * Parse a matrix in a ZigZag way.
 * 
 * @author shivam.maharshi
 */
public class ZigZagMatrix {

	public static void zigZagContinous(int[][] mat) {
		if (mat == null || mat.length == 0)
			return;
		int maxRow = mat.length - 1;
		int maxCol = mat[0].length - 1;
		int row = 0, col = 0;
		boolean goRight = true, goDown = false, goSlantUp = false, goSlantDown = false;
		while (row != maxRow - 1 && col != maxCol - 1) {
			System.out.println(mat[row][col]);
			if (goRight) {
				if (col == maxCol - 1) {
					row++;
					goDown = true;
					goRight = false;
				} else {
					row++;
					goRight = false;
					goSlantDown = true;
				}
			} else if (goSlantDown) {
				if (col == 0) {
					row++;
					goSlantUp = true;
					goSlantDown = false;
				}
				if (row == maxRow - 1) {
					col++;
					goRight = true;
					goSlantDown = false;
				} else {
					row++;
					col--;
				}
			} else if (goSlantUp) {

			}
		}

	}

	public static void zigZagParsing(int[][] mat) {
		if (mat == null || mat.length == 0) {
			return;
		}
		int n = mat.length;
		int var = 0;
		int row = n - 1;
		// This will print the left mid bottom part.
		outer: while (true) {
			for (int col = var; col >= 0; col--) {
				System.out.println(mat[row][col]);
				if (row == col && row == 0)
					break outer;
				row--;
			}
			var++;
			row = n - 1;
		}

		// This will print the right mid top part.
		int col = n - 1;
		var = n - 2;
		while (var >= 0) {
			for (row = var; row >= 0; row--) {
				System.out.println(mat[row][col]);
				col--;
			}
			var--;
			col = n - 1;
		}

	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		int[] b = new int[] { 6, 7, 8, 9, 10 };
		int[] c = new int[] { 11, 12, 13, 14, 15 };
		int[] d = new int[] { 16, 17, 18, 19, 20 };
		int[] e = new int[] { 21, 22, 23, 24, 25 };
		int[][] mat = new int[][] { a, b, c, d, e };
		ZigZagMatrix.zigZagParsing(mat);
	}

}
