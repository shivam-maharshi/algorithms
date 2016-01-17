package data.structures;

import java.util.ArrayList;
import java.util.List;

/**
 * This is also called the radix tree, digital tree or prefix tree.
 * 
 * @author shivam.maharshi
 */
public class Trie {

	private boolean value;
	private Trie[] nodes;
	private static Integer ASCII_OFFSET = 97;

	public Trie(boolean value) {
		if (value) {
			this.nodes = new Trie[26];
			this.value = true;
		}
	}

	public Boolean find(String pattern) {
		Trie root = this;
		if (pattern == null || pattern.length() == 0)
			return false;
		pattern = pattern.toLowerCase();
		char[] patArr = pattern.toCharArray();
		for (int i = 0; i < patArr.length; i++) {
			if (root != null && root.value) {
				root = root.nodes[(int) patArr[i] - ASCII_OFFSET];
			} else {
				return false;
			}
		}
		return true;
	}

	public static Trie createTrie(List<String> words) {
		Trie root = null;
		if (words == null || words.isEmpty())
			return null;
		root = new Trie(true);
		for (int i = 0; i < words.size(); i++) {
			root.add(words.get(i));
		}
		return root;
	}

	public void add(String word) {
		Trie node = this;
		if (word == null || word.length() == 0)
			return;
		word = word.toLowerCase();
		char[] wordArr = word.toCharArray();
		for (int i = 0; i < wordArr.length; i++) {
			Trie tempNode = node.getNodes()[wordArr[i] - ASCII_OFFSET];
			if (tempNode != null && tempNode.value) {
				node = tempNode;
			} else {
				node.getNodes()[wordArr[i] - ASCII_OFFSET] = new Trie(true);
				node = node.getNodes()[wordArr[i] - ASCII_OFFSET];
			}
		}
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public Trie[] getNodes() {
		return nodes;
	}

	public void setNodes(Trie[] nodes) {
		this.nodes = nodes;
	}

	public static List<String> getTestData() {
		List<String> words = new ArrayList<String>();
		words.add("rat");
		words.add("cat");
		words.add("dog");
		words.add("sheep");
		words.add("shipped");
		words.add("californication");
		return words;
	}

	public static void main(String[] args) {
		Trie trie = Trie.createTrie(getTestData());
		System.out.println(trie.find("california"));
	}

}
