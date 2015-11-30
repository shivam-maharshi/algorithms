package array;

import java.util.Arrays;

/**
 * Given a matrix zero out given rows and columns.
 * 
 * Link: http://www.careercup.com/question?id=5144615611006976
 * 
 * @author shivam.maharshi
 */
public class ZeroOutMatrix {

	public static int[][] zeroOut(int[][] a, int[] row, int[] col) {
		for (int i = 0; i < row.length; i++) {
			int j = row[i];
			int k = col[i];
			zeroOut(a, j, k);
		}
		return a;
	}

	private static void zeroOut(int[][] a, int row, int col) {
		for (int i = 0; i < a[row].length; i++) {
			a[row][i] = 0;
		}
		for (int i = 0; i < a.length; i++) {
			a[i][col] = 0;
		}
	}

	private static void printMatrix(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		int[][] a = new int[10][10];
		for (int i = 0; i < a.length; i++) {
			Arrays.fill(a[i], 1);
		}
		int[] row = new int[] { 0, 2 };
		int[] col = new int[] { 1, 3 };
		ZeroOutMatrix.zeroOut(a, row, col);
		printMatrix(a);
	}

}
