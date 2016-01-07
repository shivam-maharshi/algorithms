package math;

/**
 * Write a function that generates one of 3 numbers according to given
 * probabilities
 * 
 * Link:
 * http://www.geeksforgeeks.org/write-a-function-to-generate-3-numbers-according
 * -to-given-probabilities/
 * 
 * @author shivam.maharshi
 */
public class RandGeneratorThreeNumGivenProb {

	public static int rand(int a, int b, int c, int pa, int pb, int pc) {
		int val = rand(1, 100);
		if (val < pa)
			return a;
		if (val < pa + pb)
			return b;
		else
			return c;
	}

	/*
	 * Given a function rand(a, b) which generates equiprobable random numbers
	 * between [a, b] inclusive.
	 */
	public static int rand(int a, int b) {
		return a + (int) Math.round((b - a) * Math.random());
	}

	public static void main(String[] args) {
		System.out.println(rand(40, 25, 35, 1, 2, 3));
	}

}
