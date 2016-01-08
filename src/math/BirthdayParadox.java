package math;

/**
 * How many people must be there in a room to make the probability 50% that two
 * people in the room have same birthday?
 * 
 * Very important. Must read the theory behind it.
 * 
 * Link: http://www.geeksforgeeks.org/birthday-paradox/
 * 
 * @author shivam.maharshi
 */
public class BirthdayParadox {

	public static int getPeople(double p) {
		return (int) Math.ceil(Math.sqrt(2 * 365 * Math.log((1 / (1 - p)))));
	}

	public static void main(String[] args) {
		System.out.println(getPeople(.50));
	}
}
