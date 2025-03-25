package Leetcode.Difficulty.Easy;

public class MinimElement_After_Replacement_With_Digit_Sum_3300 {

    public int minElement(int[] nums) {
        int result = 100000;

        for (int num : nums) {
            result = Math.min(result, getDigit(num));
        }
        return result;
    }

    private int getDigit(int num) {
        int rem = 0;
        while (num > 0) {
            rem += (num % 10);
            num = num / 10;
        }
        return rem;
    }

}
