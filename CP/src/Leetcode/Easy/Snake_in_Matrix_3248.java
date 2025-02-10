package Leetcode.Easy;

import java.util.List;

public class Snake_in_Matrix_3248 {

    public int finalPositionOfSnake(int n, List<String> commands) {
        int row = 0;
        int col = 0;

        for (String command : commands) {
            if (command.equals("RIGHT"))
                col++;
            else if (command.equals("LEFT"))
                col--;
            else if (command.equals("UP"))
                row--;
            else
                row++;
        }
        return (row * n) + col;
    }

}
