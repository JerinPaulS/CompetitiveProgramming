package Leetcode.Challeneges.YR2025.Feb;

import java.util.Stack;

public class Construct_Smallest_Number_From_DI_String_2375 {

    public String smallestNumber(String pattern) {
        Stack<String> stack = new Stack<>();
        String res = "";
        int index = 0;
        for (index = 0; index < pattern.length(); index++) {
            if (pattern.charAt(index) == 'D') {
                stack.add(Integer.toString(index + 1));
            } else {
                res += Integer.toString(index + 1);
                while (!stack.empty()) {
                    res += stack.pop();
                }
            }
        }
        res += Integer.toString(index + 1);
        while (!stack.empty()) {
            res += stack.pop();
        }
        return res;
    }

}
