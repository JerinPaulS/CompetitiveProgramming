package Leetcode.DailyChallenge.YR2025.Feb;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits_2342 {

    public int maximumSum(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> freq = new HashMap<>();

        for (int num : nums) {
            int key = getDigitSum(num);
            freq.computeIfAbsent(key, (list) -> new PriorityQueue(Collections.reverseOrder())).add(num);
        }
        System.out.println(freq);
        int result = -1;

        for (int key : freq.keySet()) {
            PriorityQueue<Integer> values = freq.get(key);
            if (values.size() < 2)
                continue;
            result = Math.max(result, values.poll() + values.poll());
        }
        return result;
    }

    private int getDigitSum(int num) {
        int rem = 0;
        while (num > 0) {
            rem += (num % 10);
            num = num / 10;
        }
        return rem;
    }

}
