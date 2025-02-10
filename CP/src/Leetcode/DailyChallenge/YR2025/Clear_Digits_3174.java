package Leetcode.DailyChallenge.YR2025;

import java.util.Stack;

public class Clear_Digits_3174 {

    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        for (int index = 0; index < s.length(); index ++) {
            char ch = s.charAt(index);
            if (Character.isLetter(ch)) {
                stack.add(ch);
            } else {
                if (!stack.empty())
                    stack.pop();
            }
        }
        String result = "";

        while (!stack.empty())
             result = stack.pop() + result;
        return result;
}

}
