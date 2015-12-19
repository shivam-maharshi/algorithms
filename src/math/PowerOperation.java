package math;

/**
 * Write power operation without using multiplication or division.
 * 
 * Link:
 * http://www.geeksforgeeks.org/write-you-own-power-without-using-multiplication-and-division/
 * 
 * @author shivam.maharshi
 */
public class PowerOperation {

	public static int get(int n, int pow) {
		int a = n;
		int b = n;
		for (int i = 1; i < pow; i++) {
			for (int j = 1; j < n; j++) {
				a += b;
			}
			b = a;
		}
		System.out.println(a);
		return a;
	}

	public static void main(String[] args) {
		PowerOperation.get(5, 6);
	}

}
