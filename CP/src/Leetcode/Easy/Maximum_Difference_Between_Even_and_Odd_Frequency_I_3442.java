package Leetcode.Easy;

import java.util.HashMap;

public class Maximum_Difference_Between_Even_and_Odd_Frequency_I_3442 {

    public int maxDifference(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int index=0; index < s.length(); index++) {
            freq.put(s.charAt(index), freq.getOrDefault(s.charAt(index), 0) + 1);
        }
        int odd_max = -1;
        int even_min = 10000;

        for (Character ch : freq.keySet()) {
            if (freq.get(ch) % 2 == 0) {
                even_min = Math.min(even_min, freq.get(ch));
            } else {
                odd_max = Math.max(odd_max, freq.get(ch));
            }
        }
        return odd_max - even_min;
    }

}
