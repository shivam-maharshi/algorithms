package backtracking;

/**
 * Given a partially filled 9*9 2D array grid[9][9], the goal is to assign
 * digits (from 1 to 9) to the empty cells so that every row, column, and
 * subgrid of size 3*3 contains exactly one instance of the digits from 1 to 9.
 * 
 * Link: http://www.geeksforgeeks.org/backtracking-set-7-suduku/
 * 
 * @author shivam.maharshi
 */
public class Sudoku {

	public static void solve(int[][] grid) {
		for(int i=1;i<9;i++) {
			if(solve(0, 1, i, grid)) {
				printSol(grid);
				return;
			}
		}
		System.out.println("Not possible.");
	}

	private static boolean solve(int x, int y, int num, int[][] grid) {
		grid[x][y] = num;
		if (isComplete(grid))
			return true;

		Point point = getNextBlock(x, y, grid);
		while (!isValidBlock(point.x, point.y, grid)) {
			point = getNextBlock(point.x, point.y, grid);
		}

		for (int i = 1; i < 10; i++) {
			if (isValidMove(point.x, point.y, i, grid)) {
				if (!solve(point.x, point.y, i, grid)) {
					grid[point.x][point.y] = 0;
				} else {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean isValidBlock(int x, int y, int[][] grid) {
		return grid[x][y] == 0;
	}

	private static Point getNextBlock(int x, int y, int[][] grid) {
		if (x == grid.length - 1 && y == grid.length - 1)
			return null;
		if (y < grid.length - 1) {
			return new Point(x, y + 1);
		} else {
			return new Point(x + 1, 0);
		}
	}

	private static boolean isComplete(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	private static boolean isValidMove(int x, int y, int num, int[][] grid) {
		if (x < 0 || x >= grid.length || y < 0 || y >= grid.length)
			return false;
		for (int i = 0; i < grid.length; i++)
			if (grid[x][i] == num)
				return false;
		for (int i = 0; i < grid.length; i++)
			if (grid[i][y] == num)
				return false;
		for (int i = (x / 3) * 3; i < (x / 3) * 3 + 3; i++) {
			for (int j = (y / 3) * 3; j < (y / 3) * 3 + 3; j++) {
				if (grid[i][j] == num)
					return false;
			}
		}
		return true;
	}
	
	private static void printSol(int[][] grid) {
		for(int i=0;i< grid.length;i++) {
			for(int j=0;j<grid.length;j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		int[][] grid = new int[][]{{3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0 } };

		solve(grid);
	}

}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

}
