package Revision.Day_2_Recursion_Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenExample {

    static void solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        List<List<String>> solutions = new ArrayList<>();
        placeQueens(board, 0, solutions);

        System.out.println("Total Solutions: " + solutions.size());
        for (List<String> sol : solutions) {
            for (String row : sol) {
                System.out.println(row);
            }
            System.out.println("----------------");
        }
    }

    static void placeQueens(char[][] board, int row, List<List<String>> solutions) {
        if (row == board.length) {
            solutions.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                placeQueens(board, row + 1, solutions);
                board[row][col] = '.'; // backtrack
            }
        }
    }

    static boolean isSafe(char[][] board, int row, int col) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }

        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] row : board) {
            res.add(new String(row));
        }
        return res;
    }

    public static void main(String[] args) {
        int N = 4;
        solveNQueens(N);
    }
}


/*
Total Solutions: 2
.Q..
...Q
Q...
..Q.
----------------
..Q.
Q...
...Q
.Q..
----------------

 */