package google;

/**
 * Find the no of possible patterns in android lock screen. write a program to
 * count them.
 * 
 * Link: http://www.careercup.com/question?id=5663422257561600
 * 
 * @author shivam.maharshi
 */
public class CountPatternsInAndroidLockScreen {

	private static int count = 0;

	private static int[][] graph = new int[][] { { 0, 1, 0, 1, 1, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1, 1, 1, 0, 1 },
			{ 0, 1, 0, 1, 1, 1, 0, 1, 0 }, { 1, 1, 1, 0, 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 0, 1, 1, 1, 1 },
			{ 1, 1, 1, 0, 1, 0, 1, 1, 1 }, { 0, 1, 0, 1, 1, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1, 1, 1, 0, 1 },
			{ 0, 1, 0, 1, 1, 1, 0, 1, 0 } };

	/*
	 * Must take care of the corner cases. 1->9 is not a valid case because 5
	 * lies in the way, however 1->5->9 is.
	 */
	public static void count(int level, int index, boolean[] visited, int minLevel) {
		if (allVisited(visited))
			return;
		if (level >= minLevel)
			count++;
		for (int i = 0; i < 9; i++) {
			if (!visited[i] && graph[index][i] == 1) {
				visited[i] = true;
				count(level + 1, i, visited, minLevel);
				visited[i] = false;
			}
		}
	}

	private static boolean allVisited(boolean[] visited) {
		for (boolean b : visited)
			if (!b)
				return false;
		return true;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 9; i++) {
			count(0, i, new boolean[9], 3);
		}
		System.out.println(count);
	}

}
