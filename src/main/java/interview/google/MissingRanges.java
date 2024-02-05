package interview.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/3055
 */
public class MissingRanges {

    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        final List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(getList(lower, upper));
            return result;
        }

        int low = lower, high = upper, i = 0;

        while (i < nums.length) {
            if (nums[i] > low) {
                result.add(getList(low, nums[i] - 1));
                low = nums[i] + 1;
            } else if (nums[i] == low) {
                low = nums[i] + 1;
            }
            i++;
        }

        if (low <= upper) {
            result.add(getList(low, high));
        }

        return result;
    }

    private List<Integer> getList(int lower, int upper) {
        return Arrays.asList(lower, upper);
    }

}
