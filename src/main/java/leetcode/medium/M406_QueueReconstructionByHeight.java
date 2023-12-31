package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Link: https://leetcode.com/problems/queue-reconstruction-by-height
 * 
 * @author shivam.maharshi
 */
public class M406_QueueReconstructionByHeight {
  
  public static void main(String[] args) {
    int[][] p = new int[][]{{7,0},{7,1},{5,2},{6,1},{4,4},{5,0}};
    reconstructQueue(p);
  }

  public static int[][] reconstructQueue(int[][] people) {
    if (people == null || people.length == 0)
      return people;
    List<int[]> r = new ArrayList<>();
    Arrays.sort(people, new HeightSort());
    for (int i = 0; i < people.length; i++)
      r.add(people[i][1], people[i]);
    int[][] ra = new int[people.length][people[0].length];
    for (int i = 0; i < people.length; i++)
      ra[i] = r.get(i);
    return ra;
  }

  private static class HeightSort implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
      if (o1[0] > o2[0]) {
        return -1;
      } else if (o1[0] < o2[0]) {
        return 1;
      } else {
        if (o1[1] < o2[1])
          return -1;
        return 1;
      }
    }
  }

}
