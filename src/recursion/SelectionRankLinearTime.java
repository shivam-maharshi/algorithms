package recursion;

import java.util.Arrays;

/**
 * Select the kth smallest element from an array in worst case linear time.
 * O(n). Also known as "Median of Median".
 * 
 * Link:
 * http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3
 * -worst-case-linear-time/
 * 
 * @author shivam.maharshi
 */
public class SelectionRankLinearTime {
  
  public static void main(String[] args) {
    int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    System.out.println(getKth(a, 3));
  }
  
  public static int getKth(int[] a, int k) {
    return getKth(a, k, 0, a.length - 1);
  }
  
  // Will only be called for array of size 5.
  public static int getMedian(int[] a, int l, int h) {
    Arrays.sort(a, l, h + 1);
    return a[l + ((h-l)/2)];
  }
  
  public static int getKth (int[] a, int k, int l, int h) {
    
    if ( k >= 0 && k <= h - l + 1)  {
      int n = h - l + 1; // 5 - 0 + 1
      int[] medians = new int[( n + 4 )/5]; // 10/5
      int i = l, j = 0;
      while(i <= h) {
        if (i + 4 < h)
          medians[j] = getMedian(a, i, i + 4);
        else
          medians[j] = getMedian(a, i, h);
        i+= 5;
        j++;
      }
      --j;
      // This will make a good pivot due to balanced partition.
      int mom =  j <= 1 ? medians[0] :  getKth(medians, j / 2, 0, j);
      
      int medianPosition = pivotize(a, l, h, mom) - l;
      
      if (medianPosition == k)
        return a[medianPosition + l];
      else if( medianPosition < k)
        return getKth(a, k - medianPosition, l + 1 + medianPosition, h);
      return getKth(a, k-1, l, l + medianPosition - 1 );
    }
    return Integer.MAX_VALUE;
  }
  
  public static int pivotize(int[] a, int l, int h, int n) {
    while (h > l) {
      if (a[l] < n)
        l++;
      else if(a[h] > n)
        h--;
      else {
        swap(a, l, h);
      }
    }
    return l;
  }
  
  public static void swap(int[] a, int l, int h) {
    int temp = a[l];
    a[l] = a[h];
    a[h] = temp;
  }

}
