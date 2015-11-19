package array;

/**
 * Consider a stream of doubles. At any moment find the moving average of the
 * last k numbers. If received less than k numbers than return average of only
 * those numbers.
 * 
 * @author shivam.maharshi
 */
public class StreamAverage {

	public static void runningAverage(double[] stream, int k) {
		double avg = 0F;
		double[] store = new double[k];
		int i = 0, sl = stream.length;
		boolean touchedK = false;
		for (int j = 0; j < sl; j++) {
			if (j == k) {
				touchedK = true;
			}
			if (i == k) {
				i = 0;
			}
			if (touchedK) {
				avg = (avg * k - store[i] + stream[j]) / k;
			} else {
				avg = (avg * (j) + stream[j]) / ( j + 1);
			}
			System.out.println(avg);
			store[i] = stream[j];
			i++;
		}
	}

	public static void main(String[] args) {
		double[] stream = new double[] { 1, 3, 5, 7, 0, 2, 5, 6 };
		StreamAverage.runningAverage(stream, 3);
	}

}
