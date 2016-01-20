package string;

/**
 * Search pattern naively.
 * 
 * Link:
 * http://www.geeksforgeeks.org/searching-for-patterns-set-1-naive-pattern-
 * searching/
 * 
 * @author shivam.maharshi
 */
public class SearchPatternNaive {

	public static void match(String s, String p) {
		int start = 0, i = 0, j = 0;
		if (s.length() >= p.length()) {
			while (start <= s.length() - p.length()) {
				if (s.charAt(i) == p.charAt(j)) {
					if (j == p.length() - 1) {
						System.out.println("Pattern at : " + start);
						j = 0;
						start++;
						i = start;
					}
					i++;
					j++;
				} else {
					j = 0;
					start++;
					i = start;
				}
			}
		}
	}

	public static void main(String[] args) {
		SearchPatternNaive.match("abcdefabcdgrabcdgr", "abcdgr");
	}

}
