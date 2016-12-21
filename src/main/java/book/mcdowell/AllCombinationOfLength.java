package book.mcdowell;

/**
 * Given a set of characters, print all combinations of length k.
 * 
 * Link:
 * http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in
 * -a-given-array-of-size-n/
 * 
 * @author shivam.maharshi
 */
public class AllCombinationOfLength {

	public static void print(char[] c, int k, int index, String s) {
		if (index == k) {
			System.out.println(s);
			return;
		}
		for (int i = 0; i < c.length; i++) {
			print(c, k, index + 1, s + c[i]);
		}
	}

	public static void main(String[] args) {
		char[] c = new char[] { 'a', 'b', 'c' };
		print(c, 2, 0, "");
	}

}
