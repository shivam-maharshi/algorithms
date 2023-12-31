package leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Find the largest rectangle in the histogram.
 * 
 * Link: https://leetcode.com/problems/largest-rectangle-in-histogram
 * 
 * @author shivam.maharshi
 */
public class H84_LargestRectangleInHistogram {

  public static int findRectangle(int[] heights) {
    List<Integer> indices = new ArrayList<>();
    indices.add(-1);
    int maxArea = 0;
    for (int i = 0; i < heights.length; i++) {
      while (indices.size() > 1 && heights[i] <= heights[indices.get(indices.size() - 1)])
        indices.remove(indices.size() - 1);
      indices.add(i);
      for (int j = indices.size() - 1; j >= 1; j--) {
        if (i + 1 < heights.length && heights[i + 1] >= heights[indices.get(j)])
          break;
        maxArea = Math.max(maxArea, heights[indices.get(j)] * (i - indices.get(j - 1)));
      }
    }
    return maxArea;
  }

  public static int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<Integer>();
    int ma = 0, i = 0;
    for (i = 0; i < heights.length;) {
      if (stack.isEmpty() || (heights[i] >= heights[stack.peek()])) {
        stack.push(i++);
      } else {
        int top = stack.pop();
        if (stack.empty()) {
          ma = Math.max(ma, heights[top] * i);
        } else {
          ma = Math.max(ma, heights[top] * (i - stack.peek() - 1));
        }
      }
    }

    while (!stack.isEmpty()) {
      int top = stack.pop();
      if (stack.empty()) {
        ma = Math.max(ma, heights[top] * i);
      } else {
        ma = Math.max(ma, heights[top] * (i - stack.peek() - 1));
      }
    }

    return ma;
  }

  public static void main(String[] args) {
    int[] heights = { 1, 0, 0, 0, 0, 1, 1 };
    System.out.println(largestRectangleArea(heights));
  }

}
