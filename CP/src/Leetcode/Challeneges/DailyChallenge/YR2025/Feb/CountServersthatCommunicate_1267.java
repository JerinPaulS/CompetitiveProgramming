package Leetcode.Challeneges.DailyChallenge.YR2025.Feb;

public class CountServersthatCommunicate_1267 {

    public int countServers(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[] rowsCount = new int[rows];
        int[] colsCount = new int[cols];

        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++) {
                if (grid[row][col] == 1) {
                    rowsCount[row]++;
                    colsCount[col]++;
                }
            }
        }
        int result = 0;

        for (int row=0; row<rows; row++) {
            for (int col=0; col<cols; col++) {
                if (grid[row][col] == 1 && (rowsCount[row] > 1 || colsCount[col] > 1)) {
                    result++;
                }
            }
        }

        return result;
    }

}
