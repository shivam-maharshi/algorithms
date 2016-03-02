package microsoft;

import java.util.HashSet;
import java.util.Set;

/**
 * You are given a matrix of dimensions m*n where each cell in the matrix can
 * have values 0,1 or 2 which has the following meaning: 0:empty cell. 1:cells
 * have fresh oranges. 2:cells have rotten oranges. So we have to determine what
 * is the minimum time required so that all the oranges will be rotten,assuming
 * it takes one second to rot the immediate neighbors. A rotten orange at index
 * [i,j] can rot other fresh orange at indexes [i+1,j] ,[i,j+1] ,[i-1,j]
 * ,[i,j-1]. If it is impossible to rot every orange then simply return -1
 * 
 * Link: https://leetcode.com/discuss/50141/maximum-time-to-rot-all-oranges
 * 
 * @author shivam.maharshi
 */
public class MaxTimeToRotAllOranges {

	private static int[] xa = new int[] { 0, 0, -1, 1 };
	private static int[] ya = new int[] { -1, 1, 0, 0 };

	/*
	 * Time Complexity: O(n^2*m^2). Which is really bad and can be improved.
	 */
	public static int getTime(int[][] a) {
		int count = 0;
		// Scope of improving time complexity here from O(n*m).
		while (count < a.length * a[0].length) {
			if (allRotten(a))
				return count;
			count++;
			Set<Cell> s = rotNeighbors(a);
			for (Cell c : s) {
				a[c.x][c.y] = 2;
			}
		}
		return -1;
	}

	// Time Complexity: O(n*m)
	private static Set<Cell> rotNeighbors(int[][] a) {
		Set<Cell> list = new HashSet<>();
		for (int x = 0; x < a.length; x++) {
			for (int y = 0; y < a[0].length; y++) {
				if (a[x][y] == 2) {
					for (int k = 0; k < 4; k++) {
						int nextX = x + xa[k];
						int nextY = y + ya[k];
						if (isValid(a, nextX, nextY) && a[nextX][nextY] == 1) {
							list.add(new Cell(nextX, nextY));
						}
					}
				}
			}
		}
		return list;
	}

	private static boolean isValid(int[][] a, int x, int y) {
		return (x >= 0 && y >= 0 && x < a.length && y < a[0].length);
	}

	private static boolean allRotten(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 1)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] a = new int[][] { { 1, 1, 2, 2 }, { 1, 2, 2, 2 }, { 2, 2, 0, 0 }, { 2, 2, 0, 1 } };
		System.out.println(getTime(a));
	}

}

class Cell {

	int x;
	int y;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
