package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Link: https://leetcode.com/problems/the-skyline-problem/
 * 
 * @author shivam.maharshi
 */
public class SkylineProblem {
  
  public static void main(String[] args) {
    int[][] buildings = {{2,9,10}, {3,7,15}, {5,12,12}, {15,20,10}, {19,24,8}};
    List<int[]> sl = getSkyline(buildings);
    for(int[] a : sl)
      System.out.print("[" + a[0] + " " + a[1] + "], ");
  }
  
  /*
   * This is a O(n2) solution and not a simplified version. A better version should be coded.
   */
  public static List<int[]> getSkyline(int[][] buildings) {
    Stack<Integer> st = new Stack<>();
    List<int[]> res = new ArrayList<int[]>();
    for(int i=0; i<buildings.length; i++) {
      if(st.isEmpty()) {
        st.push(i);
        res.add(new int[]{buildings[i][0], buildings[i][2]});
      } else {
        if (buildings[st.peek()][1] >= buildings[i][0]) { // Top overlaps with current.
          if (buildings[st.peek()][2] > buildings[i][2]) { // Top taller than current.
            if (buildings[st.peek()][1] >= buildings[i][1]) { // Top extends further than current.
              continue; // Skip this.
            } else { // Top ends within current.
              int top = st.pop();
              if (st.isEmpty() || buildings[st.peek()][2] < buildings[i][2]) { // Next highest at top end is current.
                st.push(i);
                res.add(new int[]{buildings[top][1], buildings[i][2]});
              } else { // Next highest at top end is next stack element.
                res.add(new int[]{buildings[top][1], buildings[st.peek()][2]});
                pushCurrent(st, buildings, i);
              }
            }
          } else if (buildings[st.peek()][2] < buildings[i][2]) { // Top smaller than current.
            st.push(i);
            res.add(new int[]{buildings[i][0], buildings[i][2]});
          } else { // Top same as current.
            if (buildings[st.peek()][1] < buildings[i][1])  { // Top extends less than current.
              st.push(i);
            }
          }
        } else { // Top doesn't overlaps.
          Integer top = st.pop(); // Remove the top till you find next height extending further than top.
          while (!st.isEmpty() && buildings[top][1] >= buildings[st.peek()][1]) {
            st.pop();
          }
          if (!st.isEmpty()) {
            res.add(new int[]{buildings[top][1], buildings[st.peek()][2]});
          } else {
            res.add(new int[]{buildings[top][1], 0});
          }
          i--;
          continue;
        }
      }
    }
    
    while(!st.isEmpty()) {
      Integer top = st.pop(); // Remove the top till you find next height extending further than top.
      if(!st.isEmpty()) {
        while (buildings[top][1] >= buildings[st.peek()][1]) {
          st.pop();
        }
        if (!st.isEmpty()) {
          res.add(new int[]{buildings[top][1], buildings[st.peek()][2]});
          top = st.peek();
          st.pop();
        } else {
          res.add(new int[]{buildings[top][1], 0});
        }
      } else {
        res.add(new int[]{buildings[top][1], 0});
      }
    }
    
    return res;
  }
  
  public static void pushCurrent(Stack<Integer> st, int[][] buildings, int cur) {
    Stack<Integer> temp = new Stack<Integer>();
    boolean addCur = true;
    while (!st.isEmpty() && buildings[st.peek()][2] >= buildings[cur][2]) { // Stack is not empty and top is taller or equal to cur.
      if (buildings[st.peek()][2] == buildings[cur][2]) { // Top equal to current.
        if (buildings[st.peek()][1] >= buildings[cur][1]) // Top reaches farther or equal to current.
          addCur = false;
        break;
      } else {
        temp.push(st.pop());
      }
    }
    
    if(addCur)
      st.push(cur);
    
    while(!temp.isEmpty()) {
      st.push(temp.pop());
    }
    
  }

}
