package math;

/**
 * MS Excel columns has a pattern like A, B, C, … ,Z, AA, AB, AC,…. ,AZ, BA, BB,
 * … ZZ, AAA, AAB ….. etc. In other words, column 1 is named as “A”, column 2 as
 * “B”, column 27 as “AA”.
 * 
 * Link: http://www.geeksforgeeks.org/find-excel-column-name-given-number/
 * 
 * @author shivam.maharshi
 */
public class FindExcelColumn {

	public static String find(int col) {
		String res = "";
		col--;
		while (col >= 0) {
			res = getChar(col % 26) + res;
			col /= 26;
			col--;
		}
		return res;
	}

	// Returns the corresponding char.
	private static char getChar(int n) {
		return (char) (n + 65);
	}

	public static void main(String[] args) {
		System.out.println(find(1));
	}

}
