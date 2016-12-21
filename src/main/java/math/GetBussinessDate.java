package math;

import java.util.Date;

/**
 * Returns a business day date object considering Saturday and Sunday not a
 * business day.
 * 
 * Link: http://www.careercup.com/question?id=5760804016095232
 * 
 * @author shivam.maharshi
 */
public class GetBussinessDate {

	public static Date getBusinessDayFromNow(int days) {
		if (days < 0) {
			throw new RuntimeException("Incorrect value passed. Day cannot be negative.");
		}

		Date d = new Date();
		getToWeek(d, (days / 5) - 1);
		int modDays = days % 6;
		int daysFromSunday = d.getDay();
		d.setTime(d.getTime() + modDays * 24 * 3600 * 1000);
		daysFromSunday = d.getDay();
		if (daysFromSunday == 0) {
			d.setTime(d.getTime() + 1 * 24 * 3600 * 1000);
		} else if (daysFromSunday == 6) {
			d.setTime(d.getTime() + 2 * 24 * 3600 * 1000);
		}
		return d;
	}

	private static void getToWeek(Date d, int w) {
		if (w > 0) {
			d.setTime(d.getTime() + w * 7 * 24 * 3600 * 1000);
		}
	}

	public static void main(String[] args) {
		System.out.println(GetBussinessDate.getBusinessDayFromNow(1));
	}

}
