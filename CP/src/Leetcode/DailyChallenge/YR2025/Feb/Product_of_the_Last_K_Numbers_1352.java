package Leetcode.DailyChallenge.YR2025.Feb;

import java.util.ArrayList;
import java.util.List;

public class Product_of_the_Last_K_Numbers_1352 {

    private List<Integer> nums;
    private int size;

    public Product_of_the_Last_K_Numbers_1352() {
        nums = new ArrayList<>();
        nums.add(1);
        size = 0;
    }

    public void add(int num) {
        if (num == 0) {
            nums = new ArrayList<>();
            nums.add(1);
            size = 0;
        } else {
            nums.add(nums.get(nums.size() - 1) * num);
            size++;
        }
    }

    public int getProduct(int k) {
        if (size < k)
            return 0;
        return nums.get(nums.size() - 1) / nums.get(nums.size() -1 - k);
    }

}
