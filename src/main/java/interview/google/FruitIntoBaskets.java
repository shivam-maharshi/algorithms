package interview.google;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/explore/interview/card/google/67/sql-2/3046
 */
public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        int left = 0, maxFruitCount = 0;
        final Map<Integer, Integer> map = new HashMap<>();

        for (int right=0; right<fruits.length; ++right) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            while(map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) -1);
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }

            maxFruitCount = Math.max(maxFruitCount, right - left + 1);
        }

        return maxFruitCount;
    }

    public static void main(String[] args) {
        int count = new FruitIntoBaskets().totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4});
        System.out.println(count);
    }

}
