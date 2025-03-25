package Leetcode.Difficulty.Easy;

public class Find_if_Digit_Game_Can_Be_Won_3232 {

    public boolean canAliceWin(int[] nums) {
        int oneDigit = 0;
        int twoDigit = 0;

        for (int num : nums) {
            if (num > 9)
                twoDigit += num;
            else
                oneDigit += num;
        }
        if (oneDigit == twoDigit)
            return false;
        return true;
    }

}
