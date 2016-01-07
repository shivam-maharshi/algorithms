package math;

/**
 * Calculate the angle between hour hand and minute hand
 * 
 * Link: http://www.geeksforgeeks.org/calculate-angle-hour-hand-minute-hand/
 * 
 * @author shivam.maharshi
 */
public class CalculateClockAngle {

	public static double get(int hour, int minute) {
		double angle = 0;
		if (hour == 12)
			hour = 0;
		double ha = hour * 30 + minute/2;
		double ma = minute * 6;
		angle = Math.abs(ha - ma);
		return angle > 180 ? 360 - angle : angle;
	}

	public static void main(String[] args) {
		System.out.println(get(3, 30));
	}

}
