package math;

/**
 * Find the next smallest palindrome.
 * 
 * Link:
 * http://www.geeksforgeeks.org/given-a-number-find-next-smallest-palindrome-
 * larger-than-this-number/
 * 
 * @author shivam.maharshi
 */
public class FindNextSmallestPalindrome {

	public static int[] getNext(int[] n) {
		int l = n.length;
		int a = l / 2 - 1;
		int b = l / 2;
		boolean carry = false;
		if (l % 2 != 0) {
			b++;
		}
		if (!isPalindrome(n)) {
			if (n[a] <= n[b]) {
				n[a] = n[b];
			} else if (n[a] > n[b]) {
				n[b] = n[a];
			}
		} else {
			if (n[a] != 9) {
				n[a]++;
				n[b]++;
			} else {
				n[a] = 0;
				n[b] = 0;
				carry = true;
			}
		}
		a--;
		b++;
		while (a >= 0) {
			if (carry) {
				if (n[a] == 9) {
					n[a] = 0;
				} else {
					n[a]++;
					carry = false;
				}
			}
			n[b] = n[a];
			a--;
			b++;
		}
		return n;
	}

	public static void print(int[] n) {
		for (int i : n) {
			System.out.print(i);
		}
	}

	private static boolean isPalindrome(int[] n) {
		for (int i = 0; i < n.length / 2; i++) {
			if (n[i] != n[n.length - i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] n = new int[] {0, 9, 9, 9, 9, 9, 9, 0};
		print(getNext(n));
	}

}
