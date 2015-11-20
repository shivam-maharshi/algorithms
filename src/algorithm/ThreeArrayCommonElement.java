package algorithm;

import java.util.ArrayList;
import java.util.List;

// Print the common element in the given three non decreasing arrays.

public class ThreeArrayCommonElement {

	public static List<Point> getCommonPoints(int[] a, int[] b, int[] c) {
		List<Point> points = new ArrayList<Point>();
		int l = 0, m = 0, n = 0, cur = 0;
		while (l < a.length && m < b.length && n < c.length) {
			if (a[l] == b[m] && b[m] == c[n]) {
				points.add(new Point(l, m, n));
				if (l < a.length - 1) {
					l++;
				} else {
					return points;
				}
			}
			cur = Math.max(Math.max(a[l], b[m]), c[n]);
			while (a[l] < cur && l < a.length - 1) {
				l++;
			}
			while (b[m] < cur && m < b.length - 1) {
				m++;
			}
			while (c[n] < cur && n < c.length - 1) {
				n++;
			}
		}
		return points;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 1, 5, 10, 20, 40, 80 };
		int[] b = new int[] { 6, 7, 20, 80, 100 };
		int[] c = new int[] { 3, 4, 15, 20, 30, 70, 80, 120 };
		List<Point> points = ThreeArrayCommonElement.getCommonPoints(a, b, c);
		for (Point point : points) {
			System.out.println(point);
		}
	}

}

class Point {
	int l;
	int m;
	int n;

	public Point(int l, int m, int n) {
		this.l = l;
		this.m = m;
		this.n = n;
	}

	@Override
	public String toString() {
		return "Points [l=" + l + ", m=" + m + ", n=" + n + "]";
	}

}