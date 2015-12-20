package math;

/**
 * Create a Magic square. A square where all rows, columns and both diagonals
 * have the same constant sum.
 * 
 * Link: http://www.geeksforgeeks.org/magic-square/
 * 
 * @author shivam.maharshi
 */
public class MagicSquare {

	public static int[][] get(int n) {
		int[][] a = new int[n][n];
		int row = n / 2;
		int col = n - 1;
		int count = n * n;
		int val = 0;
		while (count > 0) {
			// Wrap excess values around.
			if (row == -1) {
				row = n - 1;
			}
			/*
			 * If the magic square already contains a number at the calculated
			 * position, calculated column position will be decremented by 2,
			 * and calculated row position will be incremented by 1.
			 */
			if (a[row % n][col % n] != 0) {
				col -= 2;
				row++;
				continue;
			}
			/*
			 * If the calculated row position is -1 & calculated column position
			 * is n, the new position would be: (0, n-2).
			 */
			if (row == -1 && col == n) {
				row = 0;
				col = n - 2;
				continue;
			}
			a[row % n][col % n] = ++val;
			row--;
			col++;
			count--;
		}
		return a;
	}

	public static void print(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		MagicSquare.print(get(7));
	}

}
