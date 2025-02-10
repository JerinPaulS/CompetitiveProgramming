package Leetcode.Easy;

import java.util.ArrayList;
import java.util.List;

public class Find_Indices_of_Stable_Mountains_3285 {

    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> res = new ArrayList<>();

        for (int index = 1; index < height.length; index++) {
            if (height[index - 1] > threshold)
                res.add(index);
        }
        return res;
    }

}
