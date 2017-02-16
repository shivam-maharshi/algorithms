package interview.google;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Link: https://www.interviewbit.com/problems/wave-array/
 * 
 * @author shivam.maharshi
 */
public class WaveArray {

  public static ArrayList<Integer> wave(ArrayList<Integer> a) {
    if (a == null || a.isEmpty() || a.size() == 1)
      return a;
    Collections.sort(a);
    int i = 1, j = a.size() - 1;
    while ( i < j ) {
      int t = a.get(i);
      a.set(i, a.get(j));
      a.set(j, t);
      i += 2;
      j -= 2;
    }
    return a;
  }

}
