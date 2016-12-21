package math;

/**
 * Print all the product representation of a given number. Don't print
 * duplicates.
 * 
 * Link: http://www.careercup.com/question?id=12457661
 * 
 * @author shivam.maharshi
 */
public class ProductRepresentationCombination {

	public static void print(int n, String s, int startFactor) {
		if (n == 1) {
			return;
		}
		for (int i = startFactor; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				if (s.isEmpty()) {
					System.out.println(i + " * " + n / i);
					print(n / i, "" + i, i);
				} else {
					System.out.println(s + " * " + i + " * " + n / i);
					print(n / i, s + " * " + i, i);
				}

			}
		}
	}
	
	public static void p(int n, int f, String s) {
	  for(int i=f; i<=Math.sqrt(n); i++) {
	    if(n%i==0)
	      p(n/i, f, s + " * " + i);
	  }
	  System.out.println(s + " * " + n);
	}

	public static void main(String[] args) {
		// ProductRepresentationCombination.print(24, "", 2);
		p(24, 2, "");
	}

}
