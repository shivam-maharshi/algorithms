package algorithm.recursion;

public class StringCombinations {
	private char[] cArr;
	private int wordLenght;
	private int combinationCount;
	
	public StringCombinations(String word) {
		if(word!=null) {
			wordLenght = word.length();
			cArr = word.toCharArray();
		}
	}
	
	public void printCombinations() {
		if(cArr!=null && wordLenght>0) {
			printCombination("", 0);
		}
	}
	
	private void printCombination(String word, int charIndex) {
		for(int i=-1; i<word.length(); i++) {
			StringBuilder sb = new StringBuilder(word);
			String newWord = sb.insert(i+1, cArr[charIndex]).toString();
			if(charIndex == wordLenght-1) {
				combinationCount++;
				System.out.println(combinationCount + " : " + newWord);
			} else {
				printCombination(newWord, charIndex+1);
			}
		}
	}
	
	public static void main(String[] args) {
		StringCombinations sc = new StringCombinations("abcdef");
		sc.printCombinations();
	}
	
}
