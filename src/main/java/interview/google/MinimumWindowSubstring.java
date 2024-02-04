package interview.google;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/345
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }

        int left = 0, right = 0;
        String result = "";
        int [] tCharCount = getCharCount(t);
        int [] sCharCount = new int[150];

        while (true) {
            if (!containSubstring(tCharCount, sCharCount)) {
                if (right < s.length()) {
                    sCharCount[s.charAt(right)]++;
                    right++;
                } else {
                    break;
                }
            } else {
                if (result.length() == 0 || right - left < result.length()) {
                    result = s.substring(left, right);
                }
                sCharCount[s.charAt(left)]--;
                left++;
            }
        }

        return result;
    }

    public int[] getCharCount(final String s) {
        int[] count = new int[150];
        for (int i=0; i<s.length(); i++) {
            int c = s.charAt(i);
            count[c]++;
        }
        return count;
    }

    public boolean containSubstring(final int[] tCharCount, final int[] subCharCount) {
        for (int i=0; i<tCharCount.length; i++) {
            if (subCharCount[i] < tCharCount[i])  {
                return false;
            }
        }
        return true;
    }

}
