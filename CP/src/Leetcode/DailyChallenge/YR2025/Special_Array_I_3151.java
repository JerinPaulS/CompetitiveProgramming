package Leetcode.DailyChallenge.YR2025;

public class Special_Array_I_3151 {

    public boolean isArraySpecial(int[] nums) {
        for (int index = 1; index < nums.length; index ++) {
            if ((nums[index] % 2 == 0 && nums[index - 1] % 2 ==0) ||
                    (nums[index] % 2 != 0 && nums[index - 1] % 2 !=0))
                return false;
        }
        return true;
    }

}
