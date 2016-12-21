package math;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Print pascal's triangle.
 * 
 * Link: http://www.geeksforgeeks.org/pascal-triangle/
 * 
 * @author shivam.maharshi
 */
public class PascalsTriangle {

	public static void print(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		System.out.println(1);
		for (int i = 1; i < n; i++) {
			q.add(1);
			System.out.print(1);
			for (int j = 1; j < i; j++) {
				int a = q.remove();
				int b = q.peek();
				System.out.print(a + b);
				q.add(a + b);
			}
			q.add(1);
			q.remove();
			System.out.print(1);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		print(5);
	}

}
