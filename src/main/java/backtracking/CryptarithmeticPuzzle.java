package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * The goal here is to assign each letter a digit from 0 to 9 so that the
 * arithmetic works out correctly. The rules are that all occurrences of a
 * letter must be assigned the same digit, and no digit can be assigned to more
 * than one letter.
 * 
 * Link:
 * http://www.geeksforgeeks.org/backtracking-set-8-solving-cryptarithmetic-
 * puzzles/
 * 
 * @author shivam.maharshi
 */
public class CryptarithmeticPuzzle {

	public static void solve(String a, String b, String result) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		List<Character> clist = getDistinctCharacters(a, b, result);
		for (int i = 0; i < 10; i++) {
			if (solve(i, a, b, result, map, new HashMap<Integer, Void>(), clist)) {
				printSol(map);
				return;
			}
		}
		System.out.println("Not possible.");
	}

	private static void printSol(Map<Character, Integer> map) {
		Set<Entry<Character, Integer>> set = map.entrySet();
		for (Entry<Character, Integer> entry : set) {
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}

	private static List<Character> getDistinctCharacters(String a, String b, String result) {
		Map<Character, Void> checkMap = new HashMap<Character, Void>();
		List<Character> list = new ArrayList<Character>();
		for (char c : a.toCharArray()) {
			if (!checkMap.containsKey(c)) {
				checkMap.put(c, null);
				list.add(c);
			}
		}
		for (char c : b.toCharArray()) {
			if (!checkMap.containsKey(c)) {
				checkMap.put(c, null);
				list.add(c);
			}
		}
		for (char c : result.toCharArray()) {
			if (!checkMap.containsKey(c)) {
				checkMap.put(c, null);
				list.add(c);
			}
		}
		return list;
	}

	private static boolean solve(int index, String a, String b, String result, Map<Character, Integer> map,
			Map<Integer, Void> checkMap, List<Character> clist) {
		if (isFull(map, clist))
			if (isSolved(map, a, b, result))
				return true;
			else
				return false;
		for (int i = 0; i < 10; i++) {
			if (!checkMap.containsKey(i)) {
				map.put(clist.get(index), i);
				checkMap.put(i, null);
				if (!solve(index + 1, a, b, result, map, checkMap, clist)) {
					map.remove(clist.get(index));
					checkMap.remove(i);
				} else
					return true;
			}
		}
		return false;
	}

	private static boolean isFull(Map<Character, Integer> map, List<Character> list) {
		return map.size() == list.size();
	}

	private static boolean isSolved(Map<Character, Integer> map, String a, String b, String result) {
		int av = getValue(map, a);
		int bv = getValue(map, b);
		int resultv = getValue(map, result);
		return av + bv == resultv;
	}

	private static int getValue(Map<Character, Integer> map, String a) {
		int res = 0;
		for (int i = 0; i < a.length(); i++) {
			res = 10 * res + map.get(a.charAt(i));
		}
		return res;
	}

	public static void main(String[] args) {
		solve("SEND", "MORE", "MONEY");
	}

}
