package book.mcdowell;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shivam.maharshi
 */
public class AllCombinations {
	
	public static void printAllSets(char[] c) {
		List<String> list = new ArrayList<String>();
		list.add("");
		printSets(c, 0, list);
	}
	
	private static void printSets(char[] c, int index, List<String> list) {
		if(index==c.length) return;
		int len = list.size();
		for(int i=0; i<len; i++) {
			System.out.println(list.get(i) + c[index]);
			list.add(list.get(i) + c[index]);
		}
		index++;
		printSets(c, index, list);
	}
	
	public static void main(String[] args) {
		char[] c = new char[] {'a', 'b', 'c'};
		AllCombinations.printAllSets(c);
	}

}
