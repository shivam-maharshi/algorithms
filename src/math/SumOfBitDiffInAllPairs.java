package math;

/**
 * Given an integer array of n integers, find sum of bit differences in all
 * pairs that can be formed from array elements. Bit difference of a pair (x, y)
 * is count of different bits at same positions in binary representations of x
 * and y.
 * 
 * Link: http://www.geeksforgeeks.org/sum-of-bit-differences-among-all-pairs/
 * 
 * Source: Google
 * 
 * @author shivam.maharshi
 */
public class SumOfBitDiffInAllPairs {

	// This is optimized and in O(n) complexity.
	public static int count(int[] a) {
		int res = 0;
		int[] oneCountAtIthBit = new int[32];
		for (int num : a) {
			int i = 0;
			while (num != 0) {
				if ((num & 1) == 1) {
					oneCountAtIthBit[i]++;
				}
				num >>= 1;
				i++;
			}
		}
		for (int count : oneCountAtIthBit) {
			res += 2 * (a.length - count) * count;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] a = { 1, 3, 5 };
		System.out.println(count(a));
	}

}
