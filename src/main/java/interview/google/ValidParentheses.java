package interview.google;

import java.util.ArrayDeque;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/467
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        final ArrayDeque<Character> q = new ArrayDeque<>();

        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                q.addFirst(c);
            } else {
                if (q.size() == 0 || !matchParenthesis(q.pollFirst(), c)) {
                    return false;
                }
            }
        }

        return q.size() == 0;
    }

    private boolean matchParenthesis(char open, char close) {
        if ((open == '(' && close != ')') || (open == '{' && close != '}') || (open == '[' && close != ']')) {
            return false;
        }

        return true;
    }

}
