package math;

/**
 * Given a number as a string, write a function to find the number of substrings
 * (or contiguous subsequences) of the given string which recursively add up to
 * 9.
 * 
 * Link: http://geeksquiz.com/given-number-find-number-contiguous-subsequences-
 * recursively-add-9/
 * 
 * @author shivam.maharshi
 */
public class ContSubseqAddiTo9Count {

	public static int count(String num) {
		int count = 0;
		for (int i = 0; i < num.length(); i++) {
			int sum = (int) num.charAt(i) - 48;
			if (sum == 9)
				count++;
			for (int j = i + 1; j < num.length(); j++) {
				sum += ((int) num.charAt(j) - 48) % 9;
				if (sum % 9 == 0)
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(count("4189"));
	}

}
