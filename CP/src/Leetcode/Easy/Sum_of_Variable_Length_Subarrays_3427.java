package Leetcode.Easy;

public class Sum_of_Variable_Length_Subarrays_3427 {
    public int subarraySum(int[] nums) {
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = Math.max(0, i - nums[i]); j <= i; j++) {
                result += nums[j];
            }
        }
        return result;
    }
}
