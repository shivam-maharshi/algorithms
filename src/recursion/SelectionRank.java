package recursion;

/**
 * Find the kth element from an unsorted array. In expected linear time.
 * 
 * Link:
 * http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2
 * -expected-linear-time/
 * 
 * @author shivam.maharshi
 */
public class SelectionRank {

  public static int find(int[] a, int n) {
    return n >= a.length ? Integer.MAX_VALUE : find(a, n - 1, 0, a.length - 1);
  }

  // This is expected linear time.
  public static int find(int[] a, int n, int l, int h) {
    int pos = pivotize(a, l, h, a[l]);
    if (pos == n)
      return a[pos];
    else if (pos > n)
      return find(a, n, l, pos - 1);
    else
      return find(a, n, pos + 1, h);
  }

  // Returns the index of the number a[in] in the given array after it
  // Modifies the array around n such that less elements are left to n.
  public static int pivotize(int[] a, int l, int h, int n) {
    while( l < h ) {
      if ( a[l] < n ) {
        l++;
      }
      else if ( a[h] > n ) {
        h--;
      }
      else {
        int temp = a[h];
        a[h] = a[l];
        a[l] = temp;
      }
    }
    return l;
  }
  
  public static void main(String[] args) {
    int[] a = {7, 10, 4, 3, 20, 15};
    System.out.println(find(a, 6));
  }

}
