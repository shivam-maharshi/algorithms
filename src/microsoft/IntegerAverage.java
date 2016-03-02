package microsoft;

/**
 * The definition of integer average is the highest smaller integer if average
 * is floating point number. Also the condition is that they can not use any
 * type casting or any data type other than int.
 * 
 * Example: a = 4, b = 5, avg = 4 a = 4, b = 6, avg = 5 a = -4, b = -6, avg = -5
 * a = 4, b = -5, avg = -1 a = -4, b = -5, avg = -5
 * 
 * Link: https://leetcode.com/discuss/85484/find-integer-average-of-2-integers
 * 
 * @author shivam.maharshi
 */
public class IntegerAverage {

	public static int average(int a, int b) {
		int sum = a + b;
		if(sum < 0 && sum%2==-1)
			return (sum / 2) - 1;
		else
			return sum/2;
	}

	public static void main(String[] args) {
		System.out.println(average(2, 3));
		System.out.println(average(2, -6));
		System.out.println(average(-5, -2));
		System.out.println(average(-6, 7));
	}

}
