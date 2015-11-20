package algorithm;

import java.util.HashMap;
import java.util.Map;

/* 
 * Try to recover the spaces between the words of a sentence using dictionary. Problem is, it doesn’t have entries for names, which might be present in the sentences.
 * 
 * Input: timher. Output: tim her.
 */
public class DeConcantenateWordUsingDictionary {

	private static Map<String, Boolean> map = new HashMap<String, Boolean>();

	public static String getOriginal(String word) {
		String res = "";
		int len = word.length();
		for (int i = 0; i < len; i++) {
			String pre = word.substring(0, i);
			String sub = word.substring(i, len);
			if (isPresent(sub)) {
				if (i != 0) {
					res = pre;
				}
				res += " " + sub;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		populateMap();
		System.out.println(DeConcantenateWordUsingDictionary.getOriginal("timher"));
	}

	private static void populateMap() {
		map.put("he", true);
		map.put("her", true);
	}

	public static boolean isPresent(String word) {
		return map.containsKey(word);
	}

}
