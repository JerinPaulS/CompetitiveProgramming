package Leetcode.DailyChallenge.YR2025;

public class Check_if_Array_Is_Sorted_and_Rotated_1752 {

    public boolean check(int[] nums) {
        int count = 0;
        int nums_length = nums.length;

        for (int index = 0; index < nums_length; index++) {
            if (nums[index] > nums[(index + 1) % nums_length])
                count++;
            if (count > 1)
                return false;
        }
        return true;
    }
}
