package algorithm.recursion;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Activity selection. Select the maximum number of activity that a person can
 * do, provided he can do only one activity at a given time.
 * 
 * Link:
 * http://www.geeksforgeeks.org/greedy-algorithms-set-1-activity-selection-
 * problem/
 * 
 * @author shivam.maharshi
 */
public class ActivitySelection {

	/*
	 * Without dynamic programming in worst case all the activities will be
	 * selected and hence time complexity is 2^N, because every node is getting
	 * selected or not. Space complexity is N because of stacks or recursion.
	 * See better approach below that uses greedy approach.
	 */
	public static int getMax(Activity[] a, int i) {
		Arrays.sort(a, new ActivityStartTimeComparator());
		if (i == a.length - 1)
			return 1;
		if (i >= a.length) {
			return 0;
		}
		int j = i;
		while (j < a.length) {
			if (a[i].e <= a[j].s) {
				break;
			}
			j++;
		}

		return Math.max(1 + getMax(a, j), getMax(a, i + 1));
	}

	public static void main(String[] args) {
		Activity[] a = new Activity[] { new Activity(1, 2), new Activity(3, 4), new Activity(0, 6), new Activity(5, 7),
				new Activity(8, 9), new Activity(5, 9) };
		System.out.println(ActivitySelection.getMax(a, 0));
		Arrays.sort(a, new ActivityEndTimeComparator());
		ActivitySelection.printMaxActivity(a);
	}

	/**
	 * Sort array in ascending order of end time. So thinking is to select all
	 * those tasks that finish as fast as possible. Thus now iterate over the
	 * next elements to find out the next one whose start time will be bigger
	 * than current end time. Continue this till the end of the array.
	 */
	public static void printMaxActivity(Activity[] a) {
		Activity c = a[0];
		System.out.println(c);

		for (int i = 1; i < a.length; i++) {
			if (c.e <= a[i].s) {
				c = a[i];
				System.out.println(c);
			}
		}
	}

}

class Activity {
	int s;
	int e;

	public Activity(int s, int e) {
		this.s = s;
		this.e = e;
	}

	@Override
	public String toString() {
		return "Activity [s=" + s + ", e=" + e + "]";
	}

}

class ActivityStartTimeComparator implements Comparator<Activity> {

	@Override
	public int compare(Activity o1, Activity o2) {
		if (o1.s == o2.s) {
			if (o1.e == o2.e) {
				return 0;
			} else {
				return o1.e > o2.e ? 1 : -1;
			}
		}
		return o1.s > o2.s ? 1 : -1;
	}

}

class ActivityEndTimeComparator implements Comparator<Activity> {

	@Override
	public int compare(Activity o1, Activity o2) {
		if (o1.e == o2.e) {
			return 0;
		}
		return o1.e < o2.e ? -1 : 1;
	}

}
