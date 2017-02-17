package pramp;

/**
 * Given time availabilities for two people and a duration for meeting between
 * them, find the earliest available time slot where they can conduct schedule
 * the meeting. If there is no such time slot then return an empty array.
 *
 * @author: shivam.maharshi
 */
public class Interview9 {

  public static int[] get(int[][] ta, int[][] tb, int dur) {
    int[] r = new int[2];
    if (ta == null || ta.length == 0 || tb == null || tb.length == 0)
      return r;
    int i = 0, j = 0;

    while (i < ta.length && j < tb.length) {
      int start = Math.max(ta[i][0], tb[j][0]), end = Math.min(ta[i][1], tb[j][1]);
      if (end - start >= dur) {
        r[0] = start;
        r[1] = end;
        return r;
      } else {
        if (i == ta.length - 1)
          j++;
        else if (j == tb.length - 1)
          i++;
        else if (ta[i][1] < tb[j][1])
          i++;
        else
          j++;
      }
    }
    return r;
  }

}
