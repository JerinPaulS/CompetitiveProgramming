package Leetcode.Challeneges.YR2025.Feb;

public class Lexicographically_Smallest_String_After_a_Swap_3216 {

    public String getSmallestString(String s) {
        for (int index = 1; index < s.length(); index++) {
            int curr = Character.getNumericValue(s.charAt(index));
            int prev = Character.getNumericValue(s.charAt(index - 1));

            if ((curr < prev) && ((curr % 2 == 0 && prev % 2 == 0) || (curr % 2 != 0 && prev % 2 != 0))) {
                char[] char_arr = s.toCharArray();
                char temp = char_arr[index];
                char_arr[index] = char_arr[index - 1];
                char_arr[index - 1] = temp;
                return new String(char_arr);
            }
        }
        return s;
    }

}
