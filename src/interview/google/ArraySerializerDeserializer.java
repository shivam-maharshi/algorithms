package interview.google;

/**
 * Write 2 functions to serialize and deserialize an array of strings. strings
 * can contain any unicode character. Do not worry about string overflow.
 * 
 * Link: http://www.careercup.com/question?id=5684077627703296
 * 
 * @author shivam.maharshi
 */
public class ArraySerializerDeserializer {

	public static String serialize(String[] a) {
		StringBuilder output = new StringBuilder();
		int maxLenght = 0;
		for (String s : a)
			if (s.length() > maxLenght)
				maxLenght = s.length();
		maxLenght++;
		output.append(maxLenght).append(":");
		String delimiter = generateRandString(maxLenght);
		for (String s : a)
			output.append(delimiter).append(s.length()).append(":").append(s);
		System.out.println(output.toString());
		return output.toString();
	}

	public static String[] deserialize(String s, int size) {
		String[] output = new String[size];
		StringBuilder sb = new StringBuilder();
		StringBuilder num = new StringBuilder();
		int i = 0;
		while (s.charAt(i) != ':') {
			num.append(s.charAt(i));
			i++;
		}
		i++;

		int maxWordSize = Integer.valueOf(num.toString());
		num = new StringBuilder();

		boolean parsingNum = false;
		boolean parsingDelimiter = true;
		int charCount = 0;
		int nextWordLenght = 0;
		int wordCount = 0;
		while (i < s.length()) {
			if (parsingDelimiter) {
				while (charCount < maxWordSize) {
					i++;
					charCount++;
				}
				parsingDelimiter = false;
				parsingNum = true;
				charCount = 0;
			} else if (parsingNum) {
				while (s.charAt(i) != ':') {
					num.append(s.charAt(i));
					i++;
				}
				parsingNum = false;
				nextWordLenght = Integer.valueOf(num.toString());
				num = new StringBuilder(); // Emptying.
				i++;
			} else {
				while (nextWordLenght > 0) {
					sb.append(s.charAt(i));
					i++;
					nextWordLenght--;
				}
				parsingDelimiter = true;
				output[wordCount] = sb.toString();
				wordCount++;
				sb = new StringBuilder(); // Emptying.
			}
		}
		return output;
	}

	private static String generateRandString(int size) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			sb.append((char) (65 + (26 * Math.random())));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] a = { "this", "is", "very", "nice", "I", "like" };
		String s = serialize(a);
		String[] output = deserialize(s, a.length);
		for (String out : output)
			System.out.print(out + " ");
	}

}
