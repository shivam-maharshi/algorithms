package math;

import java.util.Arrays;

/**
 * Find the largest multiple of 3 that can be made by the given numbers.
 * 
 * Link: http://www.geeksforgeeks.org/find-the-largest-number-multiple-of-3/
 * 
 * @author shivam.maharshi
 */
public class LargestMultipleOf3 {

  /*
   * This is a really bad solution. You should never code like this in the
   * interview. The whole purpose of interview will be beaten. Simply take three
   * queues and put a number in the first queue if the remainder is 0, in the
   * second if remainder is 1 and in the third when remainder is 2. Now take all
   * the elements from all the queues and check sum % 3. If this is 0, then sort
   * number in decreasing order and you got your answer. Else if it is 1, remove
   * one element from second queue. If it is null remove two elements from third
   * queue. If the sum is 2 then remove one from third queue. If it is null then
   * two element from second queue. Such an awesome answer! :)
   */
  public static void get(int[] a) {
    Arrays.sort(a);
    int sum = 0;
    for (int i = 0; i < a.length; i++) {
      sum += a[i];
    }
    int rem = sum % 3;
    if (rem == 1) {
      boolean oneFound = false;
      int twoCount = 0;
      for (int i = 0; i < a.length; i++) {
        if (a[i] % 3 == 1) {
          a[i] = -1;
          oneFound = true;
          break;
        }
      }
      if (oneFound) {
        print(a);
        return;
      }
      if (!oneFound) {
        for (int i = 0; i < a.length; i++) {
          if (a[i] % 3 == 2) {
            a[i] = -1;
            twoCount++;
            if (twoCount == 2) {
              break;
            }
          }
        }
        if (twoCount == 2) {
          print(a);
          return;
        } else {
          System.out.println("Number not possible.");
          return;
        }
      }
    } else if (rem == 2) {
      boolean twoFound = false;
      int oneCount = 0;
      for (int i = 0; i < a.length; i++) {
        if (a[i] % 3 == 2) {
          a[i] = -1;
          twoFound = true;
          break;
        }
      }
      if (twoFound) {
        print(a);
        return;
      } else {
        if (!twoFound) {
          for (int i = 0; i < a.length; i++) {
            if (a[i] % 3 == 2) {
              a[i] = -1;
              oneCount++;
              if (oneCount == 2) {
                break;
              }
            }
          }
          if (oneCount == 2) {
            print(a);
            return;
          } else {
            System.out.println("Number not possible.");
            return;
          }
        }
      }
    }
    print(a);
  }

  public static void print(int[] a) {
    for (int i = a.length - 1; i >= 0; i--) {
      if (a[i] != -1) {
        System.out.print(a[i]);
      }
    }
  }

  public static void main(String[] args) {
    get(new int[] { 8, 1, 7, 6, 0 });
  }

}
