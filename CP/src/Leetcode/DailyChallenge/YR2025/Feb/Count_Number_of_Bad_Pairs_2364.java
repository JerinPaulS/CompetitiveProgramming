package Leetcode.DailyChallenge.YR2025.Feb;

import java.util.HashMap;

public class Count_Number_of_Bad_Pairs_2364 {

    public long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        long result = 0;
        for (int index = 0; index < nums.length; index++) {
            int num = nums[index];
            int key = num - index;
            int goodPair = freq.getOrDefault(key, 0);
            result += index - goodPair;
            freq.put(key, goodPair + 1);
        }
        return result;
    }

}
