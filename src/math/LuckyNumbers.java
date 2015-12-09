package math;

/**
 * A number that doesn't get removed in a sequence given.
 * 
 * Link: http://www.geeksforgeeks.org/lucky-numbers/
 * 
 * @author shivam.maharshi
 */
public class LuckyNumbers {

	public static boolean isLucky(int n, int diff) {
		if (diff > n)
			return true;
		else if (n % diff == 0)
			return false;
		else {
			return isLucky(n - (n / diff), diff+1);
		}
	}

	public static void main(String[] args) {
		System.out.println(LuckyNumbers.isLucky(9,2));
	}

}
