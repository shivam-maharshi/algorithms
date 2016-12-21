package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Link: https://leetcode.com/problems/max-points-on-a-line/
 * 
 * @author shivam.maharshi
 */
public class MaxPointsOnALine {

  public static int maxPoints(Point[] points) {
    if (points==null || points.length==0)
      return 0;
    int r = 0;
    Map<Double, Integer> cn = new HashMap<>();
    for (int i = 0; i < points.length; i++) {
      int vertical = 0;
      int duplicates = 1;
      for (int j = i+1; j < points.length; j++) {
        if (points[i].x == points[j].x && points[i].y == points[j].y)
          duplicates++;
        else if (points[i].x == points[j].x)
          vertical++;
        else {
          double slope = points[i].y == points[j].y ? 0.0 : 1.0 * (points[i].y - points[j].y) / (points[i].x - points[j].x);
          if(!cn.containsKey(slope))
            cn.put(slope, 1);
          else 
            cn.put(slope, cn.get(slope)+1);
        }
      }
      
      for(double slope : cn.keySet())
        r = Math.max(r,  duplicates + cn.get(slope));
      
      r = Math.max(r, duplicates + vertical);
      cn.clear();
    }
    return r;
  }

  private class Point {
    int x;
    int y;

    Point() {
      x = 0;
      y = 0;
    }

    Point(int a, int b) {
      x = a;
      y = b;
    }
  }

}
