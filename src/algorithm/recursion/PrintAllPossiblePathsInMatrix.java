package algorithm.recursion;

import java.util.List;

public class PrintAllPossiblePathsInMatrix {
	
	public static void printAllPath ( Point s, Point d, List<Point> list) {
		if (s.equals(d)) {
			list.add(s);
			return;
		}
	}

}
