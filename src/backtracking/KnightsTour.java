package backtracking;

/**
 * Print the path of the of a knights tour. Also let us know if it is an open or
 * a close tour.
 * 
 * Link:
 * http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
 *
 * @author shivam.maharshi
 */
public class KnightsTour {

	private static int[] xMove = new int[] { -2, -2, -1, -1, 1, 1, 2, 2 };
	private static int[] yMove = new int[] { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void tour(int n, int x, int y) {
		int[][] board = new int[n][n];
		board[0][0] = 1;
		tour(n, x, y, 1, board);
	}

	private static boolean tour(int n, int x, int y, int count, int[][] board) {
		if (count == (n * n)) {
			printSolution(board);
			return true;
		}
		for (int i = 0; i < 8; i++) {
			int visitX = x + xMove[i];
			int visitY = y + yMove[i];
			if (isValidMove(visitX, visitY, n, board)) {
				board[x][y] = count;
				boolean finished = tour(n, visitX, visitY, count + 1, board);
				if (finished)
					return true;
				else {
					// This particular thing is backtracking.
					board[visitX][visitY] = 0;
				}
			}
		}
		return false;
	}

	private static void printSolution(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}

	private static boolean isValidMove(int x, int y, int n, int[][] board) {
		return x >= 0 && x < n && y >= 0 && y < n && board[x][y] == 0;
	}

	public static void main(String[] args) {
		tour(8, 0, 0);
	}

}
