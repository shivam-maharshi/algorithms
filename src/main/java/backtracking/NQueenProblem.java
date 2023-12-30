package backtracking;

/**
 * The N Queen is the problem of placing N chess queens on an N*N chessboard so
 * that no two queens attack each other.
 * 
 * Link: http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
 * 
 * @author shivam.maharshi
 */
public class NQueenProblem {

	/**
	 * This prints all the possible solution.
	 */
	public static void solve(int n) {
		for (int i = 0; i < n; i++) {
			if (solve(0, i, new int[n][n]))
				return;
		}
	}

	private static boolean solve(int x, int y, int[][] board) {
		if (x == board.length - 1) {
			board[x][y] = 1;
			printSol(board);
			System.out.println("");
			return true;
		}
		board[x][y] = 1;
		for (int i = 0; i < board.length; i++) {
			if (isValidMove(x + 1, i, board)) {
				if (!solve(x + 1, i, board))
					board[x + 1][i] = 0;
			}
		}
		return false;
	}

	private static boolean isValidMove(int x, int y, int[][] board) {
		if (!isValidRange(x, y, board))
			return false;
		for (int i = 0; i < board.length; i++) {
			if (isValidRange(x - i, y + i, board) && board[x - i][y + i] == 1)
				return false;
			if (isValidRange(x - i, y - i, board) && board[x - i][y - i] == 1)
				return false;
		}
		for (int i = 0; i < board.length; i++) {
			if (board[i][y] == 1)
				return false;
		}
		for (int i = 0; i < board.length; i++) {
			if (board[x][i] == 1)
				return false;
		}
		return true;
	}

	private static void printSol(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println("");
		}
	}

	private static boolean isValidRange(int x, int y, int[][] board) {
		return x >= 0 && x < board.length && y >= 0 && y < board.length;
	}

	public static void main(String[] args) {
		solve(8);
	}

}
