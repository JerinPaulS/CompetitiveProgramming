package Leetcode.Challeneges.DailyChallenge.YR2025.March;

/**
 * 1780. Check if Number is a Sum of Powers of Three
 *
 * Given an integer n, return true if it is possible to represent n as the sum of distinct powers of three. Otherwise, return false.
 *
 * An integer y is a power of three if there exists an integer x such that y == 3x.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: true
 * Explanation: 12 = 31 + 32
 * Example 2:
 *
 * Input: n = 91
 * Output: true
 * Explanation: 91 = 30 + 32 + 34
 * Example 3:
 *
 * Input: n = 21
 * Output: false
 *
 *
 * Constraints:
 *
 * 1 <= n <= 107
 */

public class Day4 {

    public boolean checkPowersOfThree(int n) {
        return checkPower(0, n);
    }

    private boolean checkPower(int power, int num) {
        if (num == 0)
            return true;
        if (Math.pow(3, power) > num)
            return false;

        boolean include = checkPower(power + 1, num - (int) Math.pow(3, power));
        boolean exclude = checkPower(power + 1, num);
        return include || exclude;
    }

}
