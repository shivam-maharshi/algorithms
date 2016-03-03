package microsoft;

/**
 * Given a two-dimensional array which only contains 0 or 1 and width m, height
 * n, Write a function to return the count of Linked areas in the array.
 * 
 * Note: 1) Linked area means when point(X,Y) = 1, if the left/right/up/down
 * connected point =1(if we say Point(X-1,Y) = 1, then continue check the
 * left/right/up/down of the point(Point(X-1,Y)) = 1, until you find all the
 * "surrounding" points = 0, these points = 1 make up a linked area 2) for
 * point(X,Y) = 1, you just need to check 4 directions: left, right, up, down.
 * 
 * Link: https://leetcode.com/discuss/48446/linked-areas-count
 * 
 * @author shivam.maharshi
 */
public class LinkedAreasCount {

	private static int[] xa = new int[] { -1, 1, 0, 0 };
	private static int[] ya = new int[] { 0, 0, -1, 1 };

	// Time complexity O(n^2).
	public static int get(int[][] a) {
		int count = 0;
		boolean[][] visited = new boolean[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (a[i][j] == 1 && visited[i][j] == false) {
					count++;
					visit(i, j, a, visited);
				}
			}
		}
		return count;
	}

	private static void visit(int x, int y, int[][] a, boolean[][] visited) {
		visited[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nextX = x + xa[i];
			int nextY = y + ya[i];
			if (isValidMove(nextX, nextY, a) && a[nextX][nextY] == 1 && !visited[nextX][nextY])
				visit(nextX, nextY, a, visited);
		}
	}

	private static boolean isValidMove(int x, int y, int[][] a) {
		return (x >= 0 && y >= 0 && x < a.length && y < a[0].length);
	}
	
	public static void main(String[] args) {
		int[][] a = new int [][] {
			{1,0,1,0,1},
			{1,1,0,0,1},
			{1,0,1,0,1},
			{0,0,0,0,1},
			{1,1,1,1,1}
		};
		System.out.println(get(a));
	}

}
