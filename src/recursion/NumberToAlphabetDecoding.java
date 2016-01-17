package recursion;

import java.util.ArrayList;
import java.util.List;

// Print all number to alphabet decoding. 
public class NumberToAlphabetDecoding {

	public static void printDecoding(int[] arr, int index, List<String> res, String word) {
		if (index >= arr.length) {
			res.add(word);
			System.out.println(word);
			return;
		}
		String oneWord = word + getChar(arr[index]);
		printDecoding(arr, index + 1, res, oneWord);
		if (index < arr.length - 1) {
			int twoDigit = arr[index] * 10 + arr[index + 1];
			if (twoDigit < 27) {
				String twoWord = word + getChar(twoDigit);
				printDecoding(arr, index + 2, res, twoWord);
			}
		}
	}

	private static char getChar(int num) {
		return (char) (num + 65);
	}
	
	public static void main(String[] args) {
		int[] arr = new int[] {9,0};
		NumberToAlphabetDecoding.printDecoding(arr, 0, new ArrayList<String>(), "");
	}

}
