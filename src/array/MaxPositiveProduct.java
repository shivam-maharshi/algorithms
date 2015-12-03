package array;

/**
 * Find the maximum positive product of three distinct numbers in an array when
 * sorting is not allowed.
 * 
 * Link: http://www.careercup.com/question?id=5203451533328384
 * 
 * @author shivam.maharshi
 *
 */
public class MaxPositiveProduct {

	public static int get(int[] a) {
		int m1 = Integer.MIN_VALUE, m2 = m1, m3 = m2;
		int n1 = Integer.MAX_VALUE, n2 = n1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > m1) {
				m1 = a[i];
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] > m2 && a[i] != m1) {
				m2 = a[i];
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] > m3 && a[i] != m1 && a[i] != m2) {
				m3 = a[i];
			}
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] < n1) {
				n1 = a[i];
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] < n2 && a[i] != n1) {
				n2 = a[i];
			}
		}

		return m1 * Math.max(m2 * m3, n1 * n2);

	}

	public static void main(String[] args) {
		int[] a = new int[] { -10, -9, -11, 1, 3, 5, 2, 8, 0, -1, 3 };
		System.out.println(MaxPositiveProduct.get(a));
	}

}
