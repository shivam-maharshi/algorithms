package bit;

import java.util.Arrays;

public class AddWithoutArithmeticOp {

	public static int add(int a, int b) {
		char[] ab = Integer.toBinaryString(a).toCharArray();
		char[] bb = Integer.toBinaryString(b).toCharArray();
		int lenA = ab.length;
		int lenB = bb.length;
		char[] res = new char[Math.max(lenA, lenB) + 1];
		Arrays.fill(res, '0');
		boolean carry = false;
		int i = lenA - 1, j = lenB - 1, k = res.length - 1;
		while (i >= 0 && j >= 0) {
			if (ab[i] == bb[j] && ab[i] == '1') {
				if (!carry) {
					res[k] = '0';
				} else {
					res[k] = '1';
				}
				carry = true;
			} else if (ab[i] != bb[j]) {
				if (!carry) {
					res[k] = '1';
				} else {
					res[k] = '0';
					carry = false;
				}
			} else {
				if (!carry) {
					res[k] = '0';
				} else {
					res[k] = '1';
					carry = false;
				}
			}
			i--;
			j--;
			k--;
		}

		if (i < 0) {
			while (j >= 0) {
				if (!carry) {
					res[k] = bb[j];
				} else if (bb[j] == 1) {
					res[k] = '0';
				} else {
					res[k] = '1';
					carry = false;
				}
				k--;
				j--;
			}

		}

		if (j < 0) {
			while (i >= 0) {
				if (!carry) {
					res[k] = ab[i];
				} else if (ab[i] == 1) {
					res[k] = '0';
				} else {
					res[k] = '1';
					carry = false;
				}
				k--;
				i--;
			}
		}

		if (carry) {
			res[k] = '1';
		}

		return Integer.valueOf(new String(res), 2);
	}

	// Breaking addition into XOR and Carry operations. Then recurse.
	public static int addBits(int a, int b) {
		if (b == 0)
			return a;
		int xor = a ^ b;
		int carry = (a & b) << 1;
		return addBits(xor, carry);
	}

	public static void main(String[] args) {
		// System.out.println(AddWithoutArithmeticOp.add(3, 65));
		System.out.println(AddWithoutArithmeticOp.addBits(3, 65));
	}

}
