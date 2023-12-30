package math;

/**
 * There are two vessels of capacities a and b respectively. We have
 * infinite water supply. Give an efficient algorithm to make exactly 1 litre of
 * water in one of the vessels. You can throw all the water from any vessel any
 * point of time. Assume that a and b are co primes.
 * 
 * Link:
 * http://www.geeksforgeeks.org/measure-1-litre-from-two-vessels-infinite-water-
 * supply/
 *
 * @author shivam.maharshi
 */
public class TwoVesselInfiniteWater {

	// We need to find x,y where y*b-x*a=1.
	public static void get(int a, int b) {
		int x = 1, y = 0;
		if (a != 1 && b != 1) {
			while (y * b - x * a != 1) {
				if (y * b > x * a) {
					x++;
				} else {
					y++;
				}
			}
		}
		System.out.println("X : " + x + " - Y : " + y);
	}

	public static void main(String[] args) {
		get(5, 8);
	}

}
