package math;

/**
 * Find out the square root of a given number.
 * 
 * Link: http://www.geeksforgeeks.org/square-root-of-a-perfect-square/
 * 
 * @author shivam.maharshi
 */
public class BabylonianForSquareRoot {

	public static float get(float n) {
		float x = n;
		float y = 1;
		float aprx = 0.00001F;
		while (Math.abs(x - y) > aprx) {
			x = (x + y) / 2;
			y = n / x;
		}
		System.out.println(x);
		return x;
	}

	public static void main(String[] args) {
		BabylonianForSquareRoot.get(50);
	}

}
