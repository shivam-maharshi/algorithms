package algorithm;

import java.text.DecimalFormat;

/**
 * Question in VMWare.
 * 
 * @author shivam.maharshi
 */
public class Solution1 {

	static float Interpolate(int n, int[] amount, String[] ucost) {
		int size = 0;
		for (int i = 0; i < ucost.length; i++) {
			if (!(Float.valueOf(ucost[i]) <= 0)) {
				size++;
			}
		}
		int[] a = new int[size];
		float[] u = new float[size];
		int j = 0;
		for (int i = 0; i < amount.length; i++) {
			if (!(Float.valueOf(ucost[i]) <= 0)) {
				a[j] = amount[j];
				u[j] = Float.valueOf(ucost[i]);
				j++;
			}
		}

		if (u.length == 1) {
			return (convertToTwoDecimal(u[0]));
		}

		for (int i = 0; i < a.length; i++) {
			if (n == a[i]) {
				return convertToTwoDecimal(u[i]);
			}
		}

		if (n < a[0]) {
			return convertToTwoDecimal(findGradient(n, a[0], a[1], u[0], u[1]));
		}

		if (n > a[a.length - 1]) {
			return convertToTwoDecimal(
					findGradient(n, a[a.length - 1], a[a.length - 2], u[u.length - 1], u[u.length - 2]));
		}

		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] < n && a[i + 1] > n) {
				return convertToTwoDecimal(findGradient(n, a[i], a[i + 1], u[i], u[i + 1]));
			}
		}

		// Never reachable.
		return 0;
	}

	public static float findGradient(int n, int a1, int a2, float u1, float u2) {
		float res = 1.0F;
		res = ((n - a1) * (u2 - u1)) / (a2 - a1);
		res += u1;
		return res;
	}

	public static float convertToTwoDecimal(float n) {
		DecimalFormat df = new DecimalFormat("#.##");
		return Float.valueOf(df.format(n));
	}

	public static void main(String[] args) {
		float f = Interpolate(501, new int[] { 10, 25, 50, 100, 500 },
				new String[] { "2.46", "2.58", "2", "2.25", "3" });
		System.out.println(f);
	}

}
