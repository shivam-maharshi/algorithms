package greedy;

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
