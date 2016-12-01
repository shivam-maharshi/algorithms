package interview.microsoft;

/**
 * Given a starting position of a knight find the path via which it can travel
 * through the complete chess board without repetition.
 * 
 * Link: https://leetcode.com/discuss/73164/knights-tour-problem
 * 
 * @author shivam.maharshi
 */
public class KnightsTour {

	private static int xa[] = new int[] { -1, -1, 1, 1, -2, -2, 2, 2 };
	private static int ya[] = new int[] { -2, 2, -2, 2, -1, 1, -1, 1 };

	public static void findPath(int n, int x, int y) {
		move(x, y, new int[n][n], new boolean[n][n], 1);
	}

	public static boolean move(int x, int y, int[][] board, boolean[][] visited, int count) {
		if (count == (board.length * board.length)) {
			board[x][y] = count;
			print(board);
			return true;
		}
		board[x][y] = count;
		visited[x][y] = true;
		for (int i = 0; i < 8; i++) {
			int nextX = x + xa[i];
			int nextY = y + ya[i];
			if (isValidMove(nextX, nextY, board) && !visited[nextX][nextY]) {
				if (move(nextX, nextY, board, visited, count + 1))
					return true;
			}
		}
		board[x][y] = 0;
		visited[x][y] = false;
		return false;
	}

	public static void print(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++)
				if (board[i][j] < 10)
					System.out.print("0" + board[i][j] + " ");
				else
					System.out.print(board[i][j] + " ");
			System.out.println("");
		}
	}

	public static boolean isValidMove(int x, int y, int[][] board) {
		return x >= 0 && y >= 0 && x < board.length && y < board.length;
	}

	public static void main(String[] args) {
		findPath(8, 2, 2);
	}

}
