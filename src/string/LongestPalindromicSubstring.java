package string;

import java.util.ArrayList;
import java.util.List;

/**
 * Finding a maximum-length contiguous substring of a given string that is also
 * a palindrome.
 * 
 * Link: https://en.wikipedia.org/wiki/Longest_palindromic_substring
 * 
 * @author shivam.maharshi
 */
public class LongestPalindromicSubstring {
	
  public String longestPalindrome(String s) {
  SuffixTree st = new SuffixTree();
  for (int i = 0; i < s.length(); i++) {
      st.add(s.substring(i, s.length()));
  }
  String sRev = "";
  for (int i = s.length() - 1; i > -1; i--) {
    sRev += s.charAt(i);
  }

  String sub = null;
  String temp = null;
  for (int i = 0; i < sRev.length(); i++) {
    temp = sRev.substring(i, s.length());
    String match = st.search(temp);
    if (sub==null || match.length() > sub.length())
      sub = match;
  }
  return sub;
}

}

class SuffixTree {

private List<Node> st = new ArrayList<Node>();

public void add(String word) {
  List<Node> dict = st;
  for (int i = 0; i < word.length(); i++) {
    boolean foundNode = false;
    char c = word.charAt(i);
    for (Node node : dict) {
      if (node.value == c) {
        foundNode = true;
        dict = node.list;
        break;
      }
    }
    if (!foundNode) {
      Node newNode = new Node(c);
      dict.add(newNode);
      dict = newNode.list;
    }
  }
}

public String search(String word) {
  List<Node> dict = st;
  String match = "";
  for (int i = 0; i < word.length(); i++) {
    boolean nodeFound = false;
    char c = word.charAt(i);
    for (Node node : dict) {
      if (node.value == c) {
        nodeFound = true;
        match += c;
        dict = node.list;
        break;
      }
    }
    if (!nodeFound)
      return match;
  }
  return match;
}

class Node {

  char value;
  List<Node> list;

  public Node(char value) {
    this.value = value;
    this.list = new ArrayList<Node>();
  }

}

}
