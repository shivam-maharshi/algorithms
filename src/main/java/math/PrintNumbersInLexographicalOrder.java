package math;

/**
 * @author shivam.maharshi
 */
public class PrintNumbersInLexographicalOrder {

	public static void printLexographicalOrder(int num, int n) {
		if (n > num)
			return;
		else {
			System.out.println(n);
			printLexographicalOrder(num, n * 10);
			if (( (n + 1) / 10) % 10 != (n / 10) % 10) {
				return;
			} else {
				printLexographicalOrder(num, n + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		PrintNumbersInLexographicalOrder.printLexographicalOrder(25, 1);
	}

}
