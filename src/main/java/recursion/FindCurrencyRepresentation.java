package recursion;

import java.util.Arrays;

public class FindCurrencyRepresentation {

	public static int getWays(int n, int[] ways) {

		if (n < 0)
			return -1;
		if (n < 5)
			return 1;
		if (n < 10)
			return 2;
		if (n < 15)
			return 4;
		if (n < 20)
			return 6;
		if (n < 25)
			return 9;
		if (n==25)
			return 12;

		if (ways[n] != -1) {
			return ways[n];
		}

		ways[n] = getWays(n - 1, ways) + getWays(n - 5, ways) + getWays(n - 10, ways) + getWays(n - 25, ways);
		return ways[n];
	}

	public static int makeChange(int n, int denom) {
		int next_denom = 0;
		switch (denom) {
		case 25:
			next_denom = 10;
			break;
		case 10:
			next_denom = 5;
			break;
		case 5:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}

		int ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			ways += makeChange(n - i * denom, next_denom);
		}
		return ways;
	}

	public static void main(String[] args) {
		int[] ways = new int[101];
		Arrays.fill(ways, -1);
		//System.out.println(FindCurrencyRepresentation.getWays(26, ways));
		System.out.println(FindCurrencyRepresentation.makeChange(25, 25));
	}

}