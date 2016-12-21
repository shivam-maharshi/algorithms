package array;

import java.util.List;

import ds.MinHeap;

/**
 * Write the best way to merge M sorted array streams.
 * 
 * Link: http://www.geeksforgeeks.org/merge-k-sorted-arrays/
 * 
 * @author shivam.maharshi
 */
public class MergeKSortedArrays {

	public static int[] mergeArray(List<int[]> arrays, int total) {
		int[] res = new int[total];
		MinHeap<Pair> h = new MinHeap<Pair>(Pair.class, arrays.size());
		int[] pointers = new int[arrays.size()];
		int count = 0;
		for (int i = 0; i < arrays.size(); i++) {
			h.add(new Pair(arrays.get(i)[0], i));
			pointers[i]++;
		}
		while (count < total) {
			Pair pair = h.extractMin();
			res[count] = pair.value;
			count++;
			pointers[pair.arrIndex] += 1;
			if (pointers[pair.arrIndex] < arrays.get(pair.arrIndex).length) {
				h.add(new Pair(arrays.get(pair.arrIndex)[pointers[pair.arrIndex]], pair.arrIndex));
			}
		}
		return res;
	}
}

class Pair implements Comparable<Pair> {

	int value;
	int arrIndex;

	public Pair(int value, int arrIndex) {
		this.value = value;
		this.arrIndex = arrIndex;
	}

	@Override
	public int compareTo(Pair o) {
		return this.value < o.value ? -1 : 1;
	}

}
