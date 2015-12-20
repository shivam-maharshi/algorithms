package math;

/**
 * Find the day of the week for a given date.
 * 
 * Link: http://www.geeksforgeeks.org/find-day-of-the-week-for-a-given-date/
 * 
 * @author shivam.maharshi
 */
public class FindDayOfWeek {

	public static int getDay(int d, int m, int y) {
		int offset = 0;
		//int[] month = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int[] moffset = new int[] { 0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5 };
		int[] mloffset = new int[] { 0, 3, 4, 0, 2, 5, 0, 3, 6, 1, 4, 6 };
		offset += d-1 + y - 2000 + getLeapYears(2000, y);
		if (isLeapYear(y)) {
			offset += mloffset[m];
		} else {
			offset += moffset[m];
		}
		// If this is 0, then it is Saturday.
		return offset%7;
	}
	
	public static void main(String[] args) {
		// 04-June-2016 is a Saturday.
		System.out.println(getDay(4, 5, 2016));
	}

	public static int getLeapYears(int p, int c) {
		int l = 0;
		for (int i = p; i < c; i++) {
			if (isLeapYear(i))
				l++;
		}
		return l;
	}

	public static boolean isLeapYear(int y) {
		return (y % 4 == 0 && y % 100 != 0) || ( y % 400 == 0);
	}
}
