package backtracking;

/**
 * A Maze is given as N*N binary matrix of blocks where source block is the
 * upper left most block i.e., maze[0][0] and destination block is lower
 * rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to
 * reach destination. The rat can move only in two directions: forward and down.
 * 
 * Link: http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
 * 
 * @author shivam.maharshi
 */
public class RatInMaze {

	public static void solve(int[][] maze) {
		int[][] sol = new int[maze.length][maze[0].length];
		if (solve(maze, 0, 0, sol))
			printSol(sol);
		else
			System.out.println("Path not possible.");
	}

	private static boolean solve(int[][] maze, int x, int y, int[][] sol) {
		if (x == maze.length - 1 && y == maze[0].length - 1) {
			sol[x][y] = 1;
			return true;
		}
		sol[x][y] = 1;
		if (isValid(x, y + 1, maze)) {
			if (solve(maze, x, y + 1, sol))
				return true;
			else
				sol[x][y + 1] = 0; // This particular thing is backtracking.
		}
		if (isValid(x + 1, y, maze)) {
			if (solve(maze, x + 1, y, sol))
				return true;
			else
				sol[x + 1][y] = 0; // This particular thing is backtracking.
		}
		return false;
	}

	private static void printSol(int[][] sol) {
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol[0].length; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.println("");
		}
	}

	private static boolean isValid(int x, int y, int[][] maze) {
		return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 1;
	}

	public static void main(String[] args) {
		int[][] maze = new int[][] { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };
		solve(maze);
	}

}
