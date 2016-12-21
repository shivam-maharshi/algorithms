package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Search pattern with worst case complexity O(m*(n-m+1)). This is just like
 * naive algorithm, except here we match the hash value of the substring of
 * length m from the text to the hash value of the pattern string. The most
 * important part is to build a HashFunction that can utilize a previous hash to
 * generate the hash of including the next character and removing the first
 * character of the previous substring.
 * 
 * Link: http://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-
 * algorithm/
 * 
 * @author shivam.maharshi
 */
public class SearchPatternRabinKarp {
	
	private static int prime = 101;
	private static int charSet = 256;
	private static int maxMul = 1;

	public static List<Integer> match(String s, String p) {
		List<Integer> pl = new ArrayList<>();
		int k = 0;
		while (k < p.length() - 1) {
			maxMul = (maxMul * charSet) % prime;
			k++;
		}

		int ph = getHash(p);
		int j = p.length();
		int sh = getHash(s.substring(0, j));
		if (ph == sh) {
			if (naiveMatch(s, 0, p)) {
				pl.add(0);
			}
		}
		
		while (j < s.length()) {
			sh = getHash(s, j - p.length(), j, sh);
			if (sh == ph && naiveMatch(s, j - p.length() +1, p))
				pl.add(j - p.length()+1);
			j++;
		}
		return pl;
	}

	private static boolean naiveMatch(String s, int i, String p) {
		for (int k = 0; k < p.length(); k++)
			if (s.charAt(k + i) != p.charAt(k))
				return false;
		return true;
	}

	private static int getHash(String s, int i, int j, int hash) {
		int newHash = ((hash - maxMul * s.charAt(i))* charSet + (int) s.charAt(j)) % prime;
		return newHash < 0 ? newHash + prime : newHash;
	}

	private static int getHash(String s) {
		int hash = 0;
		for (char ss : s.toCharArray())
			hash = (hash * charSet + ((int) ss)) % prime;
		return hash;
	}

	public static void main(String[] args) {
		List<Integer> pl = match("ABBABDB", "AB");
		for (int p : pl)
			System.out.print(p + " ");
	}

}
