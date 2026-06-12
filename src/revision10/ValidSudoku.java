package revision10;

import java.util.HashSet;

public class ValidSudoku {

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

        HashSet<String> seen = new HashSet<>();

        boolean valid = true;

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                char num = board[row][col];

                if (num == '.') {
                    continue;
                }

                String rowKey = num + "row" + row;
                String colKey = num + "col" + col;
                String boxKey = num + "box" +
                        row / 3 + "-" + col / 3;

                if (!seen.add(rowKey) ||
                        !seen.add(colKey) ||
                        !seen.add(boxKey)) {

                    valid = false;
                    break;
                }
            }
        }

        System.out.println(valid);
    }
}
