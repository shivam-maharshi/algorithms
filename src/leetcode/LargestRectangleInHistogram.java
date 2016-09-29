package leetcode;

import java.util.Stack;

/**
 * Find the largest rectangle in the histogram.
 * 
 * Link: https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * @author shivam.maharshi
 */
public class LargestRectangleInHistogram {

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
