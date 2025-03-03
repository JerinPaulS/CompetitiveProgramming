package Leetcode.DailyChallenge.YR2025.March;

public class Partition_Array_According_to_Given_Pivot_2161 {

    public int[] pivotArray(int[] nums, int pivot) {
        int less = 0;
        int equal = 0;
        for (int num : nums) {
            if (num < pivot)
                less++;
            else if (num == pivot)
                equal++;
        }

        int[] ans = new int[nums.length];
        int lessI = 0;
        int equalI = less;
        int greaterI = less + equal;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < pivot)
                ans[lessI++] = num;
            else if (num > pivot)
                ans[greaterI++] = num;
            else
                ans[equalI++] = num;
        }
        return ans;
    }

}
