package string;

public class SearchPatternRabinKarp {

	/*
	 * Search for pattern of length m in text of length n. n>m. This is just
	 * like naive algorithm, except here we match the hash value of the
	 * substring of length m from the text to the hash value of the pattern
	 * string. If the value is equal, only then we go ahead to match the
	 * complete pattern. Worst Case - O(m*(n-m+1)) best case - O(n+m)
	 * 
	 * The most important part is to build a HashFunction that can utilize a
	 * previous hash to generate the hash of including the next character and
	 * removing the first character of the previous substring.
	 */

}
