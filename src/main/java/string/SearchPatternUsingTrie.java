package string;

import java.util.List;

import ds.SearchPatternTrie;

/**
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function
 * search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[].
 * You may assume that n > m. Using Suffix Trie.
 * 
 * Link: http://www.geeksforgeeks.org/pattern-searching-set-8-suffix-tree-
 * introduction/
 * 
 * @author shivam.maharshi
 */
public class SearchPatternUsingTrie {

	// Time Complexity of only searching : O(m)
	public static List<Integer> match(String s, String p) {
		SearchPatternTrie spt = buildSuffixTrie(s, p);
		return spt.search(p);
	}

	// Time Complexity of building a this Trie : O(n*m)
	private static SearchPatternTrie buildSuffixTrie(String s, String p) {
		SearchPatternTrie trie = new SearchPatternTrie();
		StringBuilder sb = new StringBuilder();
		for (int i = s.length() - p.length(); i < s.length(); i++) {
			sb.append(s.charAt(i));
		}
		trie.insert(sb.toString(), s.length() - p.length());

		for (int i = s.length() - p.length() - 1; i >= 0; i--) {
			sb.deleteCharAt(p.length() - 1);
			sb.insert(0, s.charAt(i));
			trie.insert(sb.toString(), i);
		}
		return trie;
	}

	public static void main(String[] args) {
		List<Integer> list = match("banana", "ana");
		for (int num : list)
			System.out.print(num + " ");
	}

}
