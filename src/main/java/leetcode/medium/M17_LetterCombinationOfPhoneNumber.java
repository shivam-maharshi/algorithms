package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode:
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number
 * 
 * @author shivam.maharshi
 */
public class M17_LetterCombinationOfPhoneNumber {

  public static Map<Integer, String[]> map;

  public List<String> letterCombinations(String digits) {
    List<String> res = new ArrayList<String>();
    if (digits == null || digits.trim().length() == 0)
      return res;
    populateMap();
    addStringComb(digits, "", 0, res);
    return res;
  }

  public void addStringComb(String digits, String curComb, int i, List<String> res) {
    if (i >= digits.length()) {
      res.add(curComb);
      return;
    }
    String[] arr = map.get(Integer.valueOf(digits.charAt(i)+""));
    for (String s : arr) {
      addStringComb(digits, curComb + s, i + 1, res);
    }
  }

  public void populateMap() {
    map = new HashMap<Integer, String[]>();
    map.put(0, new String[] { " " });
    map.put(1, new String[] { "" });
    map.put(2, new String[] { "a", "b", "c" });
    map.put(3, new String[] { "d", "e", "f" });
    map.put(4, new String[] { "g", "h", "i" });
    map.put(5, new String[] { "j", "k", "l" });
    map.put(6, new String[] { "m", "n", "o" });
    map.put(7, new String[] { "p", "q", "r", "s" });
    map.put(8, new String[] { "t", "u", "v" });
    map.put(9, new String[] { "w", "x", "y", "z" });
  }

}
