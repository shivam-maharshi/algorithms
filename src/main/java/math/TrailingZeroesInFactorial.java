package math;

/**
 * Count the number of trailing zeroes in the factorial of a number.
 * 
 * Link: http://www.geeksforgeeks.org/count-trailing-zeroes-factorial-number/
 * 
 * @author shivam.maharshi
 */
public class TrailingZeroesInFactorial {
	
	public static int count(int n) {
		int res = 0;
		while(n!=0) {
			n/=5;
			res += n;
		}
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println(count(100));
	}

}
