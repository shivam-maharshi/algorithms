package visa;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a big file that cannot reside completely in-memory, write an efficient
 * string pattern matching algorithm.
 * 
 * @author shivam.maharshi
 */
public class BigFilePatternMatching {

	/**
	 * Loads a given file into a Trie data structure that stores all the words
	 * encountered  in the file and their respective counts.
	 * 
	 * @param path:
	 *            The path of the file to be loaded.
	 * @return trie: A Trie form representation of all the words and their
	 *         counts present in the file.
	 */
	private static Trie loadFile(String path) {
		// Making sure that characters are only ASCII.
		char rootValue = '0';
		Trie trie = new Trie(rootValue);
		try {
			FileInputStream fs = new FileInputStream(new File(path));
			// Won't read the complete file at once, but will read it in chunks.
			BufferedInputStream bs = new BufferedInputStream(fs);
			// More memory efficient than simply appending characters to string.
			StringBuilder sb = new StringBuilder();
			char curChar;
			while (bs.available() > 0) {
				curChar = (char) bs.read();
				/*
				 * Words are assumed to separated by space character only. More
				 * conditions like checking for comma, punctuation marks can be
				 * added here.
				 */
				if (curChar == ' ') {
					trie.insert(sb.toString());
					// Clearing up the string builder.
					sb.setLength(0);
				} else {
					sb.append(curChar);
				}
			}
			// Clear resource to avoid memory leak.
			bs.close();
			fs.close();
		} catch (FileNotFoundException e) {
			System.out
					.println("File at the given path [" + path + "] cannot be found. Please enter a valid file path.");
		} catch (IOException e) {
			System.out.println(" IO Exception : " + e.getMessage());
		}
		return trie;
	}

	/**
	 * Returns the count of this string pattern in the loaded file.
	 * 
	 * @param path:
	 *            The path of the file where the pattern is to be searched.
	 * @param pattern:
	 *            The pattern to be searched in the given file.
	 * @return count: The count of the pattern searched.
	 */
	public static int getCount(String path, String pattern) {
		return loadFile(path).search(pattern).getCount();
	}

	public static void main(String[] args) {
		System.out.println(getCount("C:/Shivam/Work/WorkSpace/Algorithms/data.txt", "file"));
	}

}

/**
 * A Trie data structure enhanced to store count of words. This is a case
 * sensitive Trie which means it considers character 'a' different from 'A'.
 */
class Trie {

	private char value;
	private int count;
	/*
	 * List saves space over array. However lookup time is increased due to
	 * linear searching for child Trie corresponding to the next character. This
	 * is 256 operations in the worst case and is a constant factor hence it
	 * doesn't affect the time complexity which is still O(k). Where k is length
	 * of the pattern.
	 */
	private List<Trie> list;

	public Trie(char c) {
		this.value = c;
		list = new ArrayList<>(); // Default size of 10.
	}

	/**
	 * Inserts the given string into trie.
	 * 
	 * @param s:
	 *            String to be inserted.
	 */
	public void insert(String s) {
		Trie root = this;
		for (char c : s.toCharArray()) {
			Trie childTrie = root.getChildTrie(c);
			if (childTrie == null) {
				childTrie = new Trie(c);
				root.list.add(childTrie);
			}
			root = childTrie;
		}
		root.count = root.count + 1;
	}

	/**
	 * Searches the Trie for the given string pattern.
	 * 
	 * @param s:
	 *            The pattern to be searched for.
	 * @return trie: The trie node which represents the string.
	 */
	public Trie search(String s) {
		Trie root = this;
		for (char c : s.toCharArray()) {
			root = root.getChildTrie(c);
			if (root == null) {
				return null;
			}
		}
		return root;
	}

	private Trie getChildTrie(char c) {
		for (Trie child : list) {
			if (child.value == c)
				return child;
		}
		return null;
	}

	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<Trie> getList() {
		return list;
	}

	public void setList(List<Trie> list) {
		this.list = list;
	}

}