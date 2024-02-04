package interview.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/explore/interview/card/google/59/array-and-strings/339
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int toAdd = 1;
        for (int i=digits.length-1; i>-1; i--) {
            if (toAdd == 1) {
                if (digits[i] != 9) {
                    digits[i] = digits[i] + 1;
                    toAdd = 0;
                    break;
                } else {
                    digits[i] = 0;
                }
            }
        }

        if (toAdd !=0) {
            int [] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i=0; i<digits.length; i++) {
                result[i+1] = digits[i];
            }
            return result;
        }

        return digits;
    }

}
