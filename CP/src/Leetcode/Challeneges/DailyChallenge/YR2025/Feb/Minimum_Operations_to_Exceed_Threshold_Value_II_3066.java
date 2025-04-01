package Leetcode.Challeneges.DailyChallenge.YR2025.Feb;

import java.util.PriorityQueue;

public class Minimum_Operations_to_Exceed_Threshold_Value_II_3066 {

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> que = new PriorityQueue<>();

        for (int num : nums) {
            que.add((long) num);
        }
        long result = 0;
        while (que.peek() < k && que.size() >= 2) {
            long x = que.poll();
            long y = que.poll();
            que.add(Math.min(x, y) * 2 + Math.max(x, y));
            result += 1;
        }
        return (int) result;
    }

}
