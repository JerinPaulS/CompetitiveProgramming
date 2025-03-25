package Leetcode.Algorithms.DynamicProgramming;

import java.util.HashMap;
/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 * Constraints:
 *
 * 0 <= n <= 30
 */

public class Fibonacci_Number_509 {

    public int fib(int n) {
        HashMap<Integer, Integer> fib = new HashMap<>();
        return helper(n, fib);
    }

    private int helper(int curr, HashMap<Integer, Integer> fib) {
        if (curr == 0)
            return 0;
        if (curr == 1)
            return 1;
        if (fib.containsKey(curr))
            return fib.get(curr);
        int res = helper(curr - 1, fib) + helper(curr - 2, fib);
        fib.put(curr, res);
        return res;
    }

}
