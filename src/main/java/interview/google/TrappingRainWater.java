package interview.google;

/**
 * Link: https://leetcode.com/explore/interview/card/google/59/array-and-strings/341
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        final int[] maxLeft = new int[height.length];
        final int[] maxRight = new int[height.length];
        int maxR = Integer.MIN_VALUE, maxL = Integer.MIN_VALUE, result = 0;

        for (int i=0; i<height.length; i++) {
            maxLeft[i] = maxL;
            if (height[i] > maxL) {
                maxL = height[i];
            }
        }

        for (int j=height.length-1; j>=0; j--) {
            maxRight[j] = maxR;
            if (height[j] > maxR) {
                maxR = height[j];
            }
        }

        for (int i=1; i<height.length-1; i++) {
            result += Math.max((Math.min(maxLeft[i], maxRight[i]) - height[i]) , 0);
        }

        return result;
    }

}
