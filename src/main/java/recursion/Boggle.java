package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Find all the possible words that can be created by visiting all neighbouring nodes without repeatedly visiting any single node.
// All these words must be present in the dictionary. Assume you have that dictionary.
public class Boggle {

	private static Map<String, Void> dictionary = new HashMap<>();

	public static void init() {
		dictionary.put("geeks", null);
		dictionary.put("quiz", null);
	}

	public static List<String> getWords(char[][] arr) {
		init();
		List<String> res = new ArrayList<>();
		boolean[][] visited = new boolean[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				getWords(arr, visited, res, i, j, "");
			}
		}
		return res;
	}

	private static void getWords(char[][] arr, boolean[][] visited, List<String> res, int row, int col, String sb) {
		sb += arr[row][col];
		if (dictionary.containsKey(sb))
			res.add(sb);
		visited[row][col] = true;
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				if (i >= 0 && j >= 0 && i < arr.length && j < arr[0].length && !visited[i][j]) {
					getWords(arr, visited, res, i, j, sb);
				}
			}
		}
		visited[row][col] = false;
	}

	public static void main(String[] args) {
		char[][] arr = new char[][] { { 'g', 'i', 'z' }, { 'u', 'e', 'k' }, { 'q', 's', 'e' } };
		List<String> res = getWords(arr);
		for (String words : res) {
			System.out.println(words);
		}
	}

}
