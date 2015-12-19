package math;

/**
 * Calculate the average of a stream of numbers.
 * 
 * Link: http://www.geeksforgeeks.org/average-of-a-stream-of-numbers/
 * 
 * @author shivam.maharshi
 */
public class StreamAverage {
	
	private static float getAvg(float avg, float n, int num) {
		return (avg*n + num)/(n+1) ;
	}
	
	public static void printStreamAvg(int[] a) {
		float avg = 0F;
		for(int i=0;i<a.length;i++) {
			avg = getAvg(avg, i, a[i]);
			System.out.println(avg);
		}
	}
	
	public static void main(String[] args) {
		printStreamAvg(new int[] {1,2,3,4,5,6,7,8,9});
	}

}
