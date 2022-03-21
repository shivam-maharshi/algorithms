package leetcode;

/**
 * Link: https://leetcode.com/problems/search-for-a-range/
 * 
 * @author shivam.maharshi
 */
public class SearchForARange {

  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    int index = 0, length = nums.length - 1, mid = 0, low = -1, high = -1;
    while (index <= length) {
      mid = index + (length - index) / 2;
      if (nums[mid] == target) {
        low = mid;
        high = mid;
        break;
      } else if (nums[mid] < target) {
        index = mid+1;
      } else {
        length = mid -1;
      }
    }
    
    getLowestRange(mid, low, index, length, nums, target);
    getHighestRange(high, mid, index, length, nums, target);
    res[0] = low;
    res[1] = high;
    return res;
  }
  public int getLowestRange(int mid, int low, int index, int length, int[] nums, int target) {
	// Get lowest range;
	    if (low != -1) {
	    	length = low;
	      index = 0;
	      while (index <= length) {
	        mid = index + (length - index) / 2;
	        if (index == length) {
	          if(nums[index]==target)
	            low = index;
	          break;
	        }
	        if (nums[mid] >= target) {
	        	length = mid - 1;
	          low = mid;
	        } else {
	          index = mid + 1;
	        }
	      }
	    }
	  return low;
  }
  public int getHighestRange(int high, int mid, int index, int length, int[] nums, int target) {
	// Get highest range;
	    if (high != -1) {
	      index = high;
	      length = nums.length - 1;
	      while (index <= length) {
	        mid = index + (length - index) / 2;
	        if (index == length) {
	          if(nums[length]==target)
	            high = length;
	          break;
	        }
	        if (nums[mid] <= target) {
	          index = mid + 1;
	          high = mid;
	        } else {
	          length = mid - 1;
	        }
	      }
	    }
	  return high;
  }
  public static void main(String[] args) {
    SearchForARange s = new SearchForARange();
    int[] nums = new int[]{1};
    int[] result = s.searchRange(nums, 1);
    for (int resultfound : result)
      System.out.print(resultfound +" ");
  }

}
