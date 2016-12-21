package leetcode;

/**
 * Link: https://leetcode.com/problems/search-for-a-range/
 * 
 * @author shivam.maharshi
 */
public class SearchForARange {

  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    int l = 0, r = nums.length - 1, mid = 0, low = -1, high = -1;
    while (l <= r) {
      mid = l + (r - l) / 2;
      if (nums[mid] == target) {
        low = mid;
        high = mid;
        break;
      } else if (nums[mid] < target) {
        l = mid+1;
      } else {
        r = mid -1;
      }
    }
    
    // Get lowest range;
    if (low != -1) {
      r = low;
      l = 0;
      while (l <= r) {
        mid = l + (r - l) / 2;
        if (l == r) {
          if(nums[l]==target)
            low = l;
          break;
        }
        if (nums[mid] >= target) {
          r = mid - 1;
          low = mid;
        } else {
          l = mid + 1;
        }
      }
    }

    // Get highest range;
    if (high != -1) {
      l = high;
      r = nums.length - 1;
      while (l <= r) {
        mid = l + (r - l) / 2;
        if (l == r) {
          if(nums[r]==target)
            high = r;
          break;
        }
        if (nums[mid] <= target) {
          l = mid + 1;
          high = mid;
        } else {
          r = mid - 1;
        }
      }
    }
    res[0] = low;
    res[1] = high;
    return res;
  }
  
  public static void main(String[] args) {
    SearchForARange s = new SearchForARange();
    int[] nums = new int[]{1};
    int[] r = s.searchRange(nums, 1);
    for (int rr : r)
      System.out.print(rr +" ");
  }

}
