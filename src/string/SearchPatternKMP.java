package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Search for pattern in the most efficient way. Worst case O(n) complexity.
 * 
 * Link:
 * http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 * 
 * @author shivam.maharshi
 */
public class SearchPatternKMP {

	public static List<Integer> match(String s, String p) {
		List<Integer> plist = new ArrayList<>();
		int[] lps = computeLps(p);
		int i = 0, j = 0;
		while (i < s.length()) {
			if (s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			}
			if (j == p.length()) {
				plist.add(i - j);
				j = lps[j - 1];
			} else if (i < s.length() && s.charAt(i) != p.charAt(j)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i++;
			}
		}
		return plist;
	}

	private static int[] computeLps(String p) {
		int[] lps = new int[p.length()];
		int len = 0;
		int i = 1;
		while (i < p.length()) {
			if (p.charAt(i) == p.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					/*
					 * This is super tricky but awesome !! If the current
					 * character did not match then check if the character lps
					 * just before it matches. If it does that means that lps
					 * value +1 is our current lps value, otherwise we have got
					 * to check with the sequence previous to that.
					 */
					len = lps[len - 1];
				} else {
					i++;
				}
			}
		}
		return lps;
	}

	public static void main(String[] args) {
		List<Integer> pl = match("ABABDABACDABABCABABABABCABAB", "ABABCABAB");
		for (int p : pl)
			System.out.print(p + " ");
	}

}
