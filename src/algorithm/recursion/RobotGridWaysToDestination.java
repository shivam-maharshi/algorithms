package algorithm.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *  Find ways for a robot to reach from 0,0 to X,Y if it can only move in Right or Bottom direction.
 */
public class RobotGridWaysToDestination {

	// Using Dynamic Programming

	// This is O(n^2).
	public static int findWaysForRobotToReachDestinationDP(int x, int y) {
		int[][] ways = new int[x + 1][y + 1];
		for (int i = 0; i < x + 1; i++) {
			ways[i][0] = 1;
		}
		for (int j = 0; j < y + 1; j++) {
			ways[0][j] = 1;
		}

		for (int i = 1; i < x + 1; i++) {
			for (int j = 1; j < y + 1; j++) {
				ways[i][j] = ways[i - 1][j] + ways[i][j - 1];
			}
		}
		return ways[x][y];
	}

	// Using combination / binomial calculations, this could be done in O(n)
	// time.
	public static int findWaysForRobotToReachDestination(int x, int y) {
		int xFact = 1, yFact = 1, sum = x + y, sumFact = 1;
		while (x != 1) {
			xFact *= x;
			x--;
		}
		while (y != 1) {
			yFact *= y;
			y--;
		}
		while (sum != 1) {
			sumFact *= sum;
			sum--;
		}
		return (sumFact / (xFact * yFact));
	}

	private static List<Point> unreachable = new ArrayList<Point>();

	public static boolean destinationReachable(Point p, List<Point> path, Map<Point, Boolean> isReachableFromCur) {
		int x = p.getX();
		int y = p.getY();

		if (x == 0 && y == 0) {
			return true;
		}

		// Already visited before.
		if (isReachableFromCur.containsKey(p)) {
			// Destination is reachable from here.
			return isReachableFromCur.get(p);
		}

		Point up = new Point(x - 1, y);
		Point left = new Point(x, y - 1);
		if (up.isValid() && !unreachable.contains(up)) {
			if (destinationReachable(up, path, isReachableFromCur)) {
				path.add(up);
				isReachableFromCur.put(up, true);
				return true;
			} else {
				isReachableFromCur.put(up, false);
				return false;
			}
		} else if (left.isValid() && !unreachable.contains(left)) {
			if (destinationReachable(left, path, isReachableFromCur)) {
				path.add(left);
				isReachableFromCur.put(left, true);
				return true;
			} else {
				isReachableFromCur.put(left, false);
				return false;
			}
		}
		return false;
	}

	public static void getPath(int x, int y) {
		Point p = new Point(x, y);
		List<Point> possiblePath = new ArrayList<Point>();
		Map<Point, Boolean> isReachableFromPoint = new HashMap<Point, Boolean>();
		if (destinationReachable(p, possiblePath, isReachableFromPoint)) {
			for (Point pathPoint : possiblePath) {
				System.out.print(pathPoint + " --> ");
			}
			System.out.print(p);
		} else {
			System.out.println("No path possible");
		}
	}

	public static void main(String[] args) {
		// System.out.println(RobotGridWaysToDestination.findWaysForRobotToReachDestinationDP(5,
		// 5));
		// System.out.println(RobotGridWaysToDestination.findWaysForRobotToReachDestination(5,
		// 5));

		unreachable.add(new Point(0, 3));
		unreachable.add(new Point(1, 0));
		unreachable.add(new Point(1, 1));
		unreachable.add(new Point(2, 2));
		//unreachable.add(new Point(2, 3));

		// System.out.println( "Contains point : " + unreachable.contains(new
		// Point ( 0,3 ) ));

		getPath(3, 3);

	}

}

class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public boolean isValid() {
		return this.x >= 0 && this.y >= 0;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "[" + x + "," + y + "]";
	}
}
