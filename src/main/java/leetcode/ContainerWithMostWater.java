package leetcode;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Leetcode: https://leetcode.com/problems/container-with-most-water/
 * 
 * @author shivam.maharshi
 */
public class ContainerWithMostWater extends TestCase {
  
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
    ContainerWithMostWater c = new ContainerWithMostWater();
    assertEquals(1, c.maxArea(new int[]{1,1}));
  }
  

}
