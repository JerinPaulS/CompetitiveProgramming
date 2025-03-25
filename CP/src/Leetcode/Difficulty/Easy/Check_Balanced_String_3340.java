package Leetcode.Difficulty.Easy;

public class Check_Balanced_String_3340 {

    public boolean isBalanced(String num) {
        int odd = 0;
        int even = 0;

        for (int index = 0; index < num.length(); index++) {
            if (index % 2 == 0) {
                even += Character.getNumericValue(num.charAt(index));
            } else {
                odd += Character.getNumericValue(num.charAt(index));
            }
        }
        return odd == even;
    }

}
