package Leetcode.DailyChallenge.YR2025.March;

import java.util.TreeMap;

public class Apply_Operations_to_an_Array_2460 {

    public int[] applyOperations(int[] nums) {
        int[] result = new int[nums.length];
        int count = 0;
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] == nums[index - 1]) {
                nums[index] = 0;
                nums[index - 1] *= 2;
                result[count] = nums[index - 1];
            }
        }

        for (int num : nums) {
            if (num > 0)
                result[count++] = num;
        }

        return result;
    }

}
