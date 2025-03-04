package Leetcode.DailyChallenge.YR2025.March;

public class Check_if_Number_is_a_Sum_of_Powers_of_Three_1780 {

    public boolean checkPowersOfThree(int n) {
        return checkPower(0, n);
    }

    private boolean checkPower(int power, int num) {
        if (num == 0)
            return true;
        if (Math.pow(3, power) > num)
            return false;

        boolean include = checkPower(power + 1, num - (int) Math.pow(3, power));
        boolean exclude = checkPower(power + 1, num);
        return include || exclude;
    }

}
