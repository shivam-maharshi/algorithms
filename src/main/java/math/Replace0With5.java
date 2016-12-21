package math;

/**
 * Replace 0 with 5 in a number.
 * 
 * Link: http://geeksquiz.com/replace-0-5-input-integer/
 * 
 * @author shivam.maharshi
 */
public class Replace0With5 {

	public static int replace(int n) {
		int res = 0;
		int num = 0;
		while (n != 0) {
			if (n % 10 == 0) {
				num = 10 * num + 5;
			} else {
				num = 10 * num + n % 10;
			}
			n /= 10;
		}
		while (num != 0) {
			res = 10 * res + num % 10;
			num /= 10;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(replace(12506));
	}

}
