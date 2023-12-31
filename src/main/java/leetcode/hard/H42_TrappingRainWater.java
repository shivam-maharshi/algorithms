package leetcode.hard;

/**
 * Link: https://leetcode.com/problems/trapping-rain-water
 * 
 * @author shivam.maharshi
 */
public class H42_TrappingRainWater {
  
  // Non DP approach.
  public int trap(int[] height) {
    if(height.length==0)
      return 0;
    int res = 0;
    for (int i = 0; i < height.length; i++) {
      int lmax = 0;
      for (int j = i - 1; j > -1; j--)
        lmax = Math.max(lmax, height[j]);
      int rmax = 0;
      for (int j = i + 1; j < height.length; j++)
        rmax = Math.max(rmax, height[j]);
      res += Math.max(0, Math.min(lmax, rmax) - height[i]);
    }
    return res;
  }

  // DP approach.
  public int trapDP(int[] height) {
    if(height.length==0)
      return 0;
    int res = 0;
    int[] hl = highestToLeft(height);
    int[] hr = highestToRight(height);
    for (int i = 0; i < height.length; i++) {
      res += Math.max(0, Math.min(hl[i], hr[i]) - height[i]);
    }
    return res;
  }

  public int[] highestToLeft(int[] a) {
    int[] h = new int[a.length];
    h[0] = 0;
    for (int i = 1; i < a.length; i++)
      h[i] = Math.max(h[i - 1], a[i - 1]);
    return h;
  }

  public int[] highestToRight(int[] a) {
    int[] h = new int[a.length];
    h[a.length - 1] = 0;
    for (int i = a.length - 2; i >= 0; i--)
      h[i] = Math.max(h[i + 1], a[i + 1]);
    return h;
  }

}
