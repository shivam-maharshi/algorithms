package math;

/**
 * Tower of Hanoi.
 * 
 * Link: http://geeksquiz.com/c-program-for-tower-of-hanoi/
 * 
 * @author shivam.maharshi
 */
public class TowerOfHanoi {

	public static void move(int n, char from, char to, char temp) {
		if (n <= 0)
			return;
		move(n - 1, from, temp, to);
		System.out.println("Move disk from " + from + " to " + to);
		move(n - 1, temp, to, from);
	}

	public static void main(String[] args) {
		move(4, 'A', 'C', 'B');
	}

}
