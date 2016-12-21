package math;

/**
 * Print all possible combinations of r elements in a given array of size n
 * 
 * Link:
 * http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in
 * -a-given-array-of-size-n/
 * 
 * @author shivam.maharshi
 */
public class PrintCombinationOfRElements {

	public static void print(int[] a, int index, int r, String s) {
		if (r == 0)
			System.out.println(s);
		for (int i = index; i < a.length; i++) {
			print(a, i + 1, r - 1, s + " " + a[i]);
		}
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 2, 3, 4, 5 };
		print(a, 0, 3, "");
	}

}
