package Leetcode.Easy;

import java.util.Arrays;

public class Minimum_Average_of_Smallest_and_Largest_Elements_3194 {

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        double result = 100000;
        int length = nums.length - 1;

        for (int index=0; index<nums.length; index++) {
            result = Math.min(result, (double) (nums[index] + nums[length - index]) / 2);
        }
        return result;
    }

}
