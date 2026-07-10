package revision13;

import java.util.HashSet;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {

        HashSet<String> set = new HashSet<>();

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char value = board[row][col];

                if (value == '.')
                    continue;

                String rowKey = value + " in row " + row;
                String colKey = value + " in col " + col;
                String boxKey = value + " in box " + (row / 3) + "-" + (col / 3);

                if (!set.add(rowKey)
                        || !set.add(colKey)
                        || !set.add(boxKey))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(isValidSudoku(board));
    }
}
