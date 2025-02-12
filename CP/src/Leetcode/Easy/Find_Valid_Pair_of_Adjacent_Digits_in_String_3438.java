package Leetcode.Easy;

import java.util.HashMap;

public class Find_Valid_Pair_of_Adjacent_Digits_in_String_3438 {

    public String findValidPair(String s) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int index = 0; index < s.length(); index++) {
            int key = Character.getNumericValue(s.charAt(index));
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        for (int index = 1; index < s.length(); index++) {
            int curr = Character.getNumericValue(s.charAt(index));
            int prev = Character.getNumericValue(s.charAt(index - 1));
            if (freq.get(prev) == prev && freq.get(curr) == curr && prev != curr)
                return Integer.toString(prev) + Integer.toString(curr);
        }
        return "";
    }

}
