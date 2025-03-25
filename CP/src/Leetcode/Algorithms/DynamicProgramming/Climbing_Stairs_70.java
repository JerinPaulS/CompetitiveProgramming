package Leetcode.Algorithms.DynamicProgramming;

import java.util.HashMap;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */

public class Climbing_Stairs_70 {
    public int climbStairs(int n) {
        HashMap<Integer, Integer> stepCount = new HashMap<>();
        return helper(0, n, stepCount);
    }

    private int helper(int current, int target, HashMap<Integer, Integer> stepCount) {
        if (current == target)
            return 1;
        if (current > target)
            return 0;
        if (stepCount.containsKey(current))
            return stepCount.get(current);
        int res = helper(current + 1, target, stepCount) + helper(current + 2, target, stepCount);
        stepCount.put(current, res);
        return res;
    }
}
