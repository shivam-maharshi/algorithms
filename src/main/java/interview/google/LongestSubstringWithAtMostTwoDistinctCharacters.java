package interview.google;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/3054
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int left = 0, right = 0, maxLength = 0;
        final Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char rChar = s.charAt(right);
            map.put(rChar, map.getOrDefault(rChar, 0) + 1);
            right++;

            while (map.size() > 2) {
                char lChar = s.charAt(left);
                map.put(lChar, map.get(lChar) - 1);
                if (map.get(lChar) == 0) {
                    map.remove(lChar);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left);
        }

        return maxLength;
    }

}
