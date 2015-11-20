package algorithm;

// Given a set of characters, print all combinations of length k.
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
		char[] c = new char[] { 'a', 'b', 'c'};
		print(c, 2, 0, "");
	}

}
