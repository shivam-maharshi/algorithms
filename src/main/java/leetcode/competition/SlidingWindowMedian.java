package leetcode.competition;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

  PriorityQueue<Integer> minHeap;
  PriorityQueue<Integer> maxHeap;

  public double[] medianSlidingWindow(int[] nums, int k) {
    double[] m = new double[nums.length - k + 1];
    if (nums == null || nums.length == 0 || k <= 0) {
      return m;
    }
    
    if (k==1 || nums.length==1) {
      for (int i=0; i<nums.length; i++)
        m[i] = nums[i];
      return m;
    }
    
    minHeap = new PriorityQueue<Integer>();
    maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
      public int compare(Integer x, Integer y) {
        return y - x;
      }
    });
    maxHeap.offer(Math.min(nums[0], nums[1]));
    minHeap.offer(Math.max(nums[0], nums[1]));

    for (int i = 2; i < k; i++) {
      add(nums[i]);
    }

    m[0] = k % 2 == 0 ? maxHeap.peek() + (minHeap.peek() - maxHeap.peek()) / 2.0D : maxHeap.peek();
    for (int i = k; i < nums.length; i++) {
      add(nums[i]);
      remove(nums[i - k]);
      m[i - (k - 1)] = k % 2 == 0 ? maxHeap.peek() + (minHeap.peek() - maxHeap.peek()) / 2.0D : maxHeap.peek();
    }
    return m;
  }

  public void add(int val) {
    int preMedian = maxHeap.peek();
    if (val > preMedian) {
      minHeap.offer(val);
    } else {
      maxHeap.offer(val);
    }
    balance();
  }

  public void remove(int val) {
    int preMedian = maxHeap.peek();
    if (val > preMedian) {
      minHeap.remove(val);
    } else {
      maxHeap.remove(val);
    }
    balance();
  }

  public void balance() {
    if (maxHeap.size() > minHeap.size() + 1) {
      minHeap.offer(maxHeap.poll());
    } else if (maxHeap.size() < minHeap.size()) {
      maxHeap.offer(minHeap.poll());
    }
  }

}
