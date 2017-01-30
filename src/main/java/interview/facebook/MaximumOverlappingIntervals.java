package interview.facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * Intervals are overlapping. Find the maximum number of such intervals
 * overlapping at one point of time.
 * 
 * @author shivam.maharshi
 */
public class MaximumOverlappingIntervals {

	// Complexity is O(n*log(n))
	@SuppressWarnings("unchecked")
  public static int max(int[] s, int[] e) {
		TreeSet<Interval> maxCountList = null;
		int maxCount = 0;
		int curCount = 0;
		List<Interval> list = new ArrayList<>();
		for (int i = 0; i < s.length; i++)
			list.add(new Interval(i, s[i], e[i]));

		Collections.sort(list, new StartComparator());

		TreeSet<Interval> visited = new TreeSet<>();

		for (Interval interval : list) {
			int removed = removeNonOverlappingIntervals(interval.s, visited);
			curCount = curCount + 1 - removed;
			visited.add(interval);
			if (curCount > maxCount) {
				maxCount = curCount;
				maxCountList = (TreeSet<Interval>) visited.clone();
			}
		}
		System.out.println(maxCount);
		print(maxCountList);
		return maxCount;
	}

	private static void print(TreeSet<Interval> set) {
		Iterator<Interval> it = set.iterator();
		while (it.hasNext())
			System.out.println(it.next().toString());
	}

	private static int removeNonOverlappingIntervals(int start, TreeSet<Interval> visited) {
		int count = 0;
		Iterator<Interval> it = visited.iterator();
		while (it.hasNext()) {
			if (start > it.next().e) {
				count++;
				it.remove();
			} else {
				break;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] s = { 5, 5, 3, 2, 6, 8, 7 };
		int[] e = { 6, 8, 8, 9, 7, 9, 8 };
		max(s, e);
	}

}

class StartComparator implements Comparator<Interval> {

	@Override
	public int compare(Interval o1, Interval o2) {
		return o1.s < o2.s ? -1 : 1;
	}

}

class Interval implements Comparable<Interval> {

	int i;
	int s;
	int e;

	public Interval(int i, int s, int e) {
		this.i = i;
		this.s = s;
		this.e = e;
	}

	@Override
	public int compareTo(Interval o) {
		return this.e < o.e ? -1 : 1;
	}

	@Override
	public String toString() {
		return "Interval [i=" + i + ", s=" + s + ", e=" + e + "]";
	}

}
