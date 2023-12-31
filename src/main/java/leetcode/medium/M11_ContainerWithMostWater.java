package leetcode.medium;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Leetcode: https://leetcode.com/problems/container-with-most-water
 * 
 * @author shivam.maharshi
 */
public class M11_ContainerWithMostWater extends TestCase {
  
  public int maxArea(int[] height) {
    int res=0, temp=0;
    int i=0, j=height.length-1;
    while(i<j) {
      temp = (j-i)*Math.min(height[j], height[i]);
      res = res < temp ? temp : res;
      if(height[j] < height[i])
        j--;
      else
        i++;
    }
    return res;
  }
  
  @Test
  public void test() {
    M11_ContainerWithMostWater c = new M11_ContainerWithMostWater();
    assertEquals(1, c.maxArea(new int[]{1,1}));
  }
  

}
