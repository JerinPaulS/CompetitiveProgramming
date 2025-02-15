package Leetcode.DailyChallenge.YR2025.Feb;

public class Find_the_Punishment_Number_of_an_Integer_2698 {

    public int punishmentNumber(int n) {
        int result = 0;

        for (int num = 1; num <= n; num++) {
            if (isPartition(Integer.toString(num * num), num))
                result += (num * num);
        }
        return result;
    }

    private boolean isPartition(String square, int target) {
        if (square.length() == 0 && target == 0)
            return true;

        if (target < 0)
            return false;

        for (int index = 0; index < square.length(); index++) {
            int val = Integer.parseInt(square.substring(0, index + 1));
            if (isPartition(square.substring(index + 1), target - val))
                return true;
        }
        return false;
    }

}
