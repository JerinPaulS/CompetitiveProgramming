package Leetcode.DailyChallenge.YR2025.March;

import java.util.TreeMap;

public class Merge_Two_2D_Arrays_by_Summing_Values_2570 {

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        TreeMap<Integer, Integer> numSum = new TreeMap<>();

        for (int index = 0; index < nums1.length; index++) {
            numSum.put(nums1[index][0], nums1[index][1]);
        }

        for (int index = 0; index < nums2.length; index++) {
            int val = numSum.getOrDefault(nums2[index][0], 0) + nums2[index][1];
            numSum.put(nums2[index][0], val);
        }
        int[][] result = new int[numSum.keySet().size()][2];
        int index = 0;
        for (int key : numSum.keySet()) {
            result[index][0] = key;
            result[index][1] = numSum.get(key);
            index++;
        }
        return result;
    }

}
