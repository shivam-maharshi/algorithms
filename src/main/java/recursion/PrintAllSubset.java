package recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllSubset {

	public static void printAllSubset(List<String> set, int index, List<String> subsets) {
		int length = set.size();
		if (index == length) {
			return;
		}
		int subsetLength = subsets.size();
		for (int i = 0; i < subsetLength; i++) {
			String subset = subsets.get(i) + set.get(index);
			System.out.println(subset);
			subsets.add(subset);
		}
		printAllSubset(set, ++index, subsets);
	}

	public static void main(String[] args) {
		List<String> subsets = new ArrayList<String>();
		subsets.add("");
		List<String> set = new ArrayList<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		printAllSubset(set, 0, subsets);
	}

}
