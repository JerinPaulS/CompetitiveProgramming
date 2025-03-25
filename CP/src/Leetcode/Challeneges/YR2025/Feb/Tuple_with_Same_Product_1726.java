package Leetcode.Challeneges.YR2025.Feb;

import java.util.HashMap;

public class Tuple_with_Same_Product_1726 {

    public int tupleSameProduct(int[] nums) {
        HashMap<Integer, Integer> nums_freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] * nums[j];
                nums_freq.put(key, nums_freq.getOrDefault(key, 0) + 1);
            }
        }

        int result = 0;
        for (int key : nums_freq.keySet()) {
            int value = nums_freq.get(key);
            result += (8 * (((value - 1) * value) / 2));
        }
        return result;

    }

}
