package string;

/**
 * Create a zig zag array from a given array that contains highest, lowest,
 * second highest, second lowest and so on elements. O(nLog(n)) time.
 * 
 * @author shivam.maharshi
 */
public class ZigZagArray {

  public static int[] wiggleArrangeArray(int[] intArr) {
    int[] res = new int[intArr.length];
    java.util.Arrays.sort(intArr);
    res = new int[intArr.length];
    int i = 0, l = 0, h = intArr.length - 1;
    while (i < intArr.length) {
      res[i] = intArr[h];
      h--;
      i++;
      if (i < intArr.length) {
        res[i] = intArr[l];
        l++;
        i++;
      }
    }
    return res;
  }

}
