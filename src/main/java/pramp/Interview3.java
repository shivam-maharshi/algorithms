package pramp;

/**
* Given an array of integer return an index where the value stored at it is the same as the index.
* If no such value exists, return -1. Assume that the array is sorted in ascending order.
*
* @author: shivam.maharshi
*/

public class Interview3 {

   // {0} - 0
   // {-1, 1} - 1
   // {-1, 2} - -1
   // {3, 4} - -1
   // {-3, -2} - -1
   
   public static int get(int[] a) {
      if (a==null || a.length == 0)
         return -1;
      return get (a, 0, a.length - 1);
   }
   
   public static int get (int[] a, int l, int h) {
      if (h == l)
         return  a[l] == l ? l : -1;
      int m = (h - l)/2 + l;
      return a[m] == m ? m : ( a[m] > m ? get(a, l, m) : get(a, m + 1, h));
   }

}
