package Leetcode.DailyChallenge.YR2025;

public class Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray_3105 {

    public int longestMonotonicSubarray(int[] nums) {
        int res = 1;
        int res1 = 1;
        int length = nums.length;
        int index = 1;
        int count = 1;

        while (index < length) {
            if (nums[index] <= nums[index - 1]) {
                count = 1;
            } else {
                count++;
            }
            res = Math.max(res, count);
            index++;
        }
        index = length - 1;
        count = 1;
        while (index > 0) {
            if (nums[index] >= nums[index - 1]) {
                count = 1;
            } else {
                count++;
            }
            res1 = Math.max(res1, count);
            index--;
        }
        return Math.max(res1, res);
    }

}
