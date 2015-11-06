package math;

// Implement Subtraction, Multiplication & Division using only addition operation.
public class ImplementOperations {

	public static int negate(int a) {
		int neg = 0;
		int d = a < 0 ? 1 : -1;
		while (a != 0) {
			neg += d;
			a += d;
		}
		return neg;
	}

	// Simply negate the value and add.
	public static int subtraction(int a, int b) {
		return a + negate(b);
	}

	// Simply add the value b times.
	public static int multiplication(int a, int b) {
		int res = 0;
		boolean isBPos = (b >= 0);
		boolean isAPos = (a >= 0);
		for (int i = 0; i < Math.abs(b); i++) {
			res = res + Math.abs(a);
		}
		return isAPos && isBPos || !isAPos && !isBPos ? res : negate(res);
	}

	// Simply divide using subtraction.
	public static int division(int a, int b) {
		boolean isAPos = a >= 0;
		boolean isBPos = b >= 0;
		a = Math.abs(a);
		b = Math.abs(b);
		int negB = negate(b);
		int res = 0;
		while (a >= 0) {
			a = a + negB;
			if (a < 0)
				break;
			res++;
		}
		return isAPos && !isBPos || !isAPos && isBPos ? negate(res) : res;
	}

	public static void main(String[] args) {
		// System.out.println(negate(5));
		// System.out.println(subtraction(5, 4));
		// System.out.println(multiplication(5, -4));
		System.out.println(division(100, -2));
	}
}
