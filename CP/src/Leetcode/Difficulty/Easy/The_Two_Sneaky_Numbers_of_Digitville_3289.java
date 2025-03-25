package Leetcode.Difficulty.Easy;

import java.util.ArrayList;

public class The_Two_Sneaky_Numbers_of_Digitville_3289 {

    public int[] getSneakyNumbers(int[] nums) {
        int[] freq = new int[nums.length];
        ArrayList<Integer> result = new ArrayList<>();

        for (int num : nums) {
            if (freq[num] == 0)
                freq[num] = 1;
            else
                result.add(num);
        }
        int[] res = new int[result.size()];

        for (int index = 0; index < result.size(); index++)
            res[index] = result.get(index);
        return res;
    }

}
