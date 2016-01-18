package google;

/**
 * How many Fibonacci numbers exists less than a given number n.Can you find a
 * function in terms of n , to get the number of fibonacci number less than n.
 * Example : n = 6 Answer: 6 as (0, 1, 1, 2, 3, 5)
 * 
 * Link: http://www.careercup.com/question?id=5713892824055808
 * 
 * @author shivam.maharshi
 */
public class FibonacciNumberLessThanN {

	public static long findFibCount(long n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		double sqrtFive = Math.sqrt(5);
		double fi = (1.0 + sqrtFive) / 2.0;
		int index = (int) (Math.log(n * sqrtFive + 0.5) / Math.log(fi));
		int res = (int) ((Math.pow(fi, index) / sqrtFive) + 0.5);
		if (res != n) {
			index += 1;
		}
		System.out.println(index);
		return index;
	}

	public static void main(String[] args) {
		findFibCount(6);
	}

}
