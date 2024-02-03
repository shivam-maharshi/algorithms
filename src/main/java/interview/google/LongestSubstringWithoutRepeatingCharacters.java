package interview.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int left = 0, maxSubstringLength = 0;
        final Set<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
            } else {
                while(s.charAt(right) != s.charAt(left)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }

            maxSubstringLength = Math.max(maxSubstringLength, right - left + 1);
        }

        return maxSubstringLength;
    }

}
