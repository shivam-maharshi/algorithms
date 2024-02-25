package interview.google;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/3056
 */
public class ExpressiveWords {

    class CharCount {
        char c;
        int count;

        CharCount(final char c, final int count) {
            this.c = c;
            this.count = count;
        }

    }

    public int expressiveWords(final String s, final String[] words) {
        int count = 0;
        final List<CharCount> sCharCount = getCharCount(s);
        for (final String word : words) {
            final List<CharCount> wCharCount = getCharCount(word);
            if (charCountMatches(sCharCount, wCharCount)) {
                count++;
            }
        }
        return count;
    }

    private List<CharCount> getCharCount(final String s) {
        final List<CharCount> cc = new ArrayList<>();
        char pc = s.charAt(0);
        int pcc = 1;
        for (int i=1; i<s.length(); i++) {
            if (pc == s.charAt(i)) {
                pcc++;
            } else {
                cc.add(new CharCount(pc, pcc));
                pc = s.charAt(i);
                pcc = 1;
            }

            if (i == s.length()-1) {
                cc.add(new CharCount(pc, pcc));
            }
        }

        return cc;
    }

    private boolean charCountMatches(final List<CharCount> s, final List<CharCount> w) {
        if (s.size() != w.size()) {
            return false;
        }

        for (int i=0; i<s.size(); i++) {
            if (s.get(i).c != w.get(i).c) {
                return false;
            }
            if (s.get(i).count != w.get(i).count && s.get(i).count - w.get(i).count < 2) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        final String[] input = new String[]{
                "dinnssoo",
                "ddinso",
                "ddiinnso",
                "ddiinnssoo",
                "ddiinso",
                "dinsoo",
                "ddiinsso",
                "dinssoo",
                "dinso"};
        new ExpressiveWords().expressiveWords("dddiiiinnssssssoooo", input);
    }

}
