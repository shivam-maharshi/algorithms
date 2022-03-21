package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * Link: https://leetcode.com/problems/the-skyline-problem/
 * 
 * @author shivam.maharshi
 */
public class SkylineProblem {

	public static void main(String[] args) {
		int[][] buildings = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };

		// int[][] buildings = { { 2, 9, 10 }, { 3, 12, 10 } };

		// List<int[]> sl = getSkyline(buildings);
		List<int[]> sl = new SkylineProblem().getLine(buildings);
		for (int[] a : sl)
			System.out.print("[" + a[0] + " " + a[1] + "], ");
	}

	/*
	 * The idea of this solution is correct but it will fail for corner cases. Need
	 * to fix it.
	 */
	public List<int[]> getLine(int[][] buildings) {
		List<int[]> result = new ArrayList<>();
		List<Pair> in = new ArrayList<>();
		for (int i = 0; i < buildings.length; i++) {
			in.add(new Pair(buildings[i][0], buildings[i][2], 0, i));
			in.add(new Pair(buildings[i][1], buildings[i][2], 1, i));
		}
		Collections.sort(in, new Pair());
		Queue<Pair> queue = new PriorityQueue<>();
		Pair pair = null;
		for (int i = 0; i < in.size(); i++) {
			pair = in.get(i);
			if (pair.cls == 0) {
				if ((queue.isEmpty() && pair.height != 0) || (pair.height >= queue.peek().height)) {
					// System.out.println("Added : " + p);
					result.add(new int[] { pair.length, pair.height });
				}
				queue.add(pair);
			} else {
				if (!queue.isEmpty() && pair.height == queue.peek().height) {
					queue.poll();
					// System.out.println("Removed : " + p);
					while (queue.peek() != null && buildings[queue.peek().index][1] <= pair.length) {
						queue.poll(); // Remove till next big that is further to cur.
					}
					result.add(new int[] { pair.length, queue.isEmpty() ? 0 : queue.peek().height });
				}
			}
		}

		int h = 0;
		for (int i = 0; i < result.size(); i++) {
			if (result.get(i)[1] == h) {
				result.remove(i);
				i--;
			} else {
				h = result.get(i)[1];
			}
		}

		return result;
	}

	class Pair implements Comparator<Pair>, Comparable<Pair> {
		int length;
		int height;
		int cls;
		int index;

		public Pair() {
		}

		public Pair(int l, int h, int cls, int index) {
			this.length = l;
			this.height = h;
			this.cls = cls;
			this.index = index;
		}

		@Override
		public int compare(Pair o1, Pair o2) {
			if (o1.length < o2.length) {
				return -1;
			} else if (o1.length == o2.length) {
				if (o1.height > o2.height) {
					return -1;
				} else if (o1.height == o2.height) {
					return o1.cls == 0 ? -1 : 1;
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}

		@Override
		public String toString() {
			return "Pair [l=" + length + ", h=" + height + ", cls=" + cls + ", index=" + index + "]";
		}

		@Override
		public int compareTo(Pair o) {
			if (this.height == o.height)
				return this.cls < o.cls ? -1 : 1;
			return this.height > o.height ? -1 : 1;
		}

	}

	/*
	 * This is a O(n2) solution and not a simplified version. A better version
	 * should be coded.
	 */
	public static List<int[]> getSkyline(int[][] buildings) {
		Stack<Integer> stack = new Stack<>();
		List<int[]> result = new ArrayList<int[]>();
		for (int i = 0; i < buildings.length; i++) {
			if (stack.isEmpty()) {
				stack.push(i);
				result.add(new int[] { buildings[i][0], buildings[i][2] });
			} else {
				if (buildings[stack.peek()][1] >= buildings[i][0]) { // Top overlaps with
																		// current.
					if (buildings[stack.peek()][2] > buildings[i][2]) { // Top taller than
																		// current.
						if (buildings[stack.peek()][1] >= buildings[i][1]) { // Top extends
																				// further than
																				// current.
							continue; // Skip this.
						} else { // Top ends within current.
							int top = stack.pop();
							if (stack.isEmpty() || buildings[stack.peek()][2] < buildings[i][2]) { // Next
								// highest
								// at
								// top
								// end
								// is
								// current.
								stack.push(i);
								result.add(new int[] { buildings[top][1], buildings[i][2] });
							} else { // Next highest at top end is next stack element.
								result.add(new int[] { buildings[top][1], buildings[stack.peek()][2] });
								pushCurrent(stack, buildings, i);
							}
						}
					} else if (buildings[stack.peek()][2] < buildings[i][2]) { // Top smaller
																				// than
																				// current.
						stack.push(i);
						result.add(new int[] { buildings[i][0], buildings[i][2] });
					} else { // Top same as current.
						if (buildings[stack.peek()][1] < buildings[i][1]) { // Top extends less
																			// than current.
							stack.push(i);
						}
					}
				} else { // Top doesn't overlaps.
					Integer top = stack.pop(); // Remove the top till you find next height
												// extending further than top.
					while (!stack.isEmpty() && buildings[top][1] >= buildings[stack.peek()][1]) {
						stack.pop();
					}
					if (!stack.isEmpty()) {
						result.add(new int[] { buildings[top][1], buildings[stack.peek()][2] });
					} else {
						result.add(new int[] { buildings[top][1], 0 });
					}
					i--;
					continue;
				}
			}
		}

		while (!stack.isEmpty()) {
			Integer top = stack.pop(); // Remove the top till you find next height
										// extending further than top.
			if (!stack.isEmpty()) {
				while (buildings[top][1] >= buildings[stack.peek()][1]) {
					stack.pop();
				}
				if (!stack.isEmpty()) {
					result.add(new int[] { buildings[top][1], buildings[stack.peek()][2] });
					top = stack.peek();
					stack.pop();
				} else {
					result.add(new int[] { buildings[top][1], 0 });
				}
			} else {
				result.add(new int[] { buildings[top][1], 0 });
			}
		}

		return result;
	}

	public static void pushCurrent(Stack<Integer> st, int[][] buildings, int cur) {
		Stack<Integer> temp = new Stack<Integer>();
		boolean addCur = true;
		while (!st.isEmpty() && buildings[st.peek()][2] >= buildings[cur][2]) { // Stack
																				// is
																				// not
																				// empty
																				// and
																				// top
																				// is
																				// taller
																				// or
																				// equal
																				// to
																				// cur.
			if (buildings[st.peek()][2] == buildings[cur][2]) { // Top equal to
																// current.
				if (buildings[st.peek()][1] >= buildings[cur][1]) // Top reaches farther
																	// or equal to
																	// current.
					addCur = false;
				break;
			} else {
				temp.push(st.pop());
			}
		}

		if (addCur)
			st.push(cur);

		while (!temp.isEmpty()) {
			st.push(temp.pop());
		}

	}

}
