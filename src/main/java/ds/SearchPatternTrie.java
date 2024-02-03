package ds;

import java.util.ArrayList;
import java.util.List;

/**
 * This is also called the radix tree, digital tree or prefix tree.
 * 
 * Link: http://www.geeksforgeeks.org/trie-insert-and-search
 * 
 * @author shivam.maharshi
 */
public class SearchPatternTrie {

	private List<Integer> value;
	private SearchPatternTrie[] nodes;

	public SearchPatternTrie() {
		value = new ArrayList<>();
		nodes = new SearchPatternTrie[256];
	}

	public SearchPatternTrie(int index) {
		if (value == null) {
			value = new ArrayList<>();
		}
		nodes = new SearchPatternTrie[256];
		value.add(index);
	}

	public boolean isPresent(String pattern) {
		List<Integer> list = search(pattern);
		return list != null && !list.isEmpty() ? true : false;
	}

	public List<Integer> search(String pattern) {
		SearchPatternTrie root = this;
		if (pattern == null || pattern.length() == 0)
			return null;
		char[] patArr = pattern.toCharArray();
		for (char c : patArr) {
			if (root != null) {
				root = root.nodes[c];
			} else {
				return null;
			}
		}
		return root == null ? null : root.value;
	}

	public void insert(String word, int index) {
		SearchPatternTrie node = this;
		if (word == null || word.length() == 0)
			return;
		char[] wordArr = word.toCharArray();
		for (int i = 0; i < wordArr.length; i++) {
			SearchPatternTrie tempNode = node.nodes[wordArr[i]];
			if (tempNode != null) {
				node = tempNode;
			} else {
				node.nodes[wordArr[i]] = new SearchPatternTrie();
				node = node.nodes[wordArr[i]];
			}
			if (i == (wordArr.length - 1)) {
				node.value.add(index);
			}
		}
	}

	public static void main(String[] args) {
		SearchPatternTrie t = new SearchPatternTrie();
		int index = 0;
		t.insert("rat", index);
		t.insert("rat", index + 1);
		t.insert("cat", index);
		t.insert("raat", index);
		t.insert("cali", index);
		t.insert("californication", index);

		System.out.println(t.isPresent("rat"));
		List<Integer> list = t.search("rat");
		System.out.println(list.get(0) + "  ::  " + list.get(1));
		System.out.println(t.isPresent("cali"));
		System.out.println(t.isPresent("californication"));
		System.out.println(t.isPresent("california"));
	}

}
