package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function
 * search(char pat[], char txt[]) that prints all occurrences of pat[] and its
 * permutations (or anagrams) in txt[]. You may assume that n > m. Expected time
 * complexity is O(n)
 * 
 * Link:
 * http://www.geeksforgeeks.org/anagram-substring-search-search-permutations/
 * 
 * @author shivam.maharshi
 */
public class SearchAnagramSubstring {

	public static List<Integer> match(String s, String p) {
		List<Integer> list = new ArrayList<Integer>();
		int[] count = new int[256];
		for (char c : p.toCharArray())
			count[c]++;
		int[] tc = new int[256];
		for (int i = 0; i < p.length(); i++) {
			tc[s.charAt(i)]++;
		}

		if (matchCount(count, tc))
			list.add(0);

		for (int i = p.length(); i < s.length(); i++) {
			tc[s.charAt(i - p.length())]--;
			tc[s.charAt(i)]++;
			if (matchCount(count, tc))
				list.add(i - p.length() + 1);
		}

		for (int num : list)
			System.out.print(num + " ");
		return list;
	}

	private static boolean matchCount(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++)
			if (a[i] != b[i])
				return false;
		return true;
	}

	public static void main(String[] args) {
		match("BACDGABCDA", "ABCD");
	}

}
