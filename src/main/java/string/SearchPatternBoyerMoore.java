package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Boyer Moore is a combination of following two approaches. 1) Bad Character
 * Heuristic 2) Good Suffix Heuristic
 * 
 * Link:
 * http://www.geeksforgeeks.org/pattern-searching-set-7-boyer-moore-algorithm-
 * bad-character-heuristic/
 * 
 * @author shivam.maharshi
 */
public class SearchPatternBoyerMoore {

	public static List<Integer> match(String s, String p) {
		List<Integer> list = new ArrayList<>();
		int[] bc = badCharacter(p);
		int i = 0; // Pat slide w.r.t text.
		int j = 0; // Pointer for pattern and text.
		while (i <= s.length() - p.length()) {
			j = p.length() - 1;
			while (j >= 0 && s.charAt(i + j) == p.charAt(j))
				j--;
			if (j < 0) {
				list.add(i);
				i += i < (s.length() - p.length()) ? p.length() - bc[s.charAt(i + p.length())] : 1;
			} else {
				i += Math.max(1, j - bc[s.charAt(i + j)]);
			}
		}

		for (int n : list)
			System.out.print(n + " ");
		return list;

	}

	private static int[] badCharacter(String p) {
		int[] bc = new int[256];
		for (int i = 0; i < p.length(); i++)
			bc[p.charAt(i)] = i;
		return bc;
	}

	public static void main(String[] args) {
		match("ABCEABCDABCEABCD", "ABCD");
	}

}
