package Leetcode.DailyChallenge.YR2025.Feb;

public class Maximum_Ascending_Subarray_Sum_1800 {

    public int maxAscendingSum(int[] nums) {
        int res = nums[0];
        int curr_count = nums[0];

        for (int index = 1; index < nums.length; index++) {
            if (nums[index - 1] >= nums[index])
                curr_count = nums[index];
            else
                curr_count += nums[index];
            res = Math.max(curr_count, res);
        }
        return res;
    }

}
