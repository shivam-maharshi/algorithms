package leetcode;

/**
 * Link: https://leetcode.com/problems/two-sum/
 * 
 * @author shivam.maharshi
 */
public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		int[] res = new int[2];
		outer:
		for(int i=0;i<nums.length-1;i++) {
			for(int j=i+1;j<nums.length;j++) {
				int sum = nums[i]+nums[j];
				if(sum==target) {
					res[0] = i;
					res[1] = j;
					break outer;
				}
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int [] a = {3,2,4};
		new TwoSum().twoSum(a, 6);
	}

}
