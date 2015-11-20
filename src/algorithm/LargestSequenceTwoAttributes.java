package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import math.LongestIncreasingSubsequence;

/*
 * Find the largest sequence of people that could be made in increasing order of their height and weight.
 */

public class LargestSequenceTwoAttributes {

	// This is a very sharp question of longest subsequence.
	public static int findLargestSequenceNum(List<P> list) {
		Collections.sort(list);
		int len = list.size();
		int [] weight = new int[len];
		for ( int i=0; i<len; i++) {
			weight[i] = list.get(i).weight;
		}
		return LongestIncreasingSubsequence.longIncreasingSequence(weight);
	}
	
	public static void main(String[] args) {
		List<P> list = new ArrayList<P>();
		list.add(new P(100, 100));
		list.add(new P(90, 80));
		list.add(new P(80, 90));
		list.add(new P(70,70));
		System.out.println(LargestSequenceTwoAttributes.findLargestSequenceNum(list));
	}

}

class P implements Comparable<P> {

	int height;
	int weight;
	
	public P ( int height, int weight ) {
		this.height = height;
		this.weight = weight;
	}

	@Override
	public int compareTo(P other) {
		if (this.height > other.height)
			return 1;
		if (this.height == other.height)
			return 0;
		return -1;
	}

}
