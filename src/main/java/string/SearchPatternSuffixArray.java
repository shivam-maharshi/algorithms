package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Search a string pattern using a build suffix array which is sorted. Apply
 * binary searching on this array to look for the presence of the pattern.
 * Benefits of using suffix array over Trie, which is simpler also is less
 * memory usage and increased cache localization.
 * 
 * It is preferred over KMP, Rabin Karp, Boyer Moore when text doesn't
 * change very frequently and there are many search queries. This is because
 * pattern length is considerably smaller than the text length.
 * 
 * Link: http://www.geeksforgeeks.org/suffix-array-set-1-introduction/
 * 
 * @author shivam.maharshi
 */
public class SearchPatternSuffixArray {

	/*
	 * Leaving aside build suffix array. Time Complexity : O(m*log(n)). m is
	 * length of p. n length of text. Using Trie the solution is obviously O(m).
	 * However even using suffix arrays O(m) is still possible.
	 */
	public static List<Integer> match(String s, String p) {
		List<Integer> list = new ArrayList<>();
		Suffix[] sa = buildSuffixArr(s);
		int l = 0, r = s.length() - 1;
		while (l < r) {
			int mid = (l + r) / 2;
			if (p.compareTo(sa[mid].s.substring(0, p.length())) == 0) {
				list = addAllMatches(sa, mid, p);
				break;
			} else if (p.compareTo(sa[mid].s.substring(0, p.length())) < 0)
				r = mid - 1;
			else
				l = mid + 1;
		}
		return list;
	}

	private static List<Integer> addAllMatches(Suffix[] sa, int mid, String p) {
		List<Integer> list = new ArrayList<>();
		int i = mid;
		while (i >= 0) {
			if (p.compareTo(sa[i].s.substring(0, p.length())) == 0) {
				list.add(sa[i].index);
				i--;
			} else
				break;
		}
		i = mid + 1;
		while (i < sa.length) {
			if (p.compareTo(sa[i].s.substring(0, p.length())) == 0) {
				list.add(sa[i].index);
				i++;
			} else
				break;
		}
		for (int num : list)
			System.out.print(num + " ");
		return list;
	}

	/*
	 * Complexity : O(n*n*lg(n)), which is horrible. Better solutions are
	 * possible for this.
	 */
	private static Suffix[] buildSuffixArr(String s) {
		Suffix[] sa = new Suffix[s.length()];
		String temp = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			temp = s.charAt(i) + temp;
			sa[i] = new Suffix(i, temp);
		}
		Arrays.sort(sa);
		return sa;
	}

	public static void main(String[] args) {
		match("abcdefabcdgrabcdgra", "abcdgr");
	}

}

class Suffix implements Comparable<Suffix> {

	int index;
	String s;

	public Suffix(int index, String s) {
		super();
		this.index = index;
		this.s = s;
	}

	@Override
	public int compareTo(Suffix o) {
		return s.compareTo(o.s);
	}
}
