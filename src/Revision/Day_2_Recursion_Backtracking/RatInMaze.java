package Revision.Day_2_Recursion_Backtracking;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        int n = maze.length;
        List<String> result = new ArrayList<>();

        boolean[][] visited = new boolean[n][n];
        if (maze[0][0] == 1) {
            solveMaze(0, 0, maze, n, visited, "", result);
        }

        if (result.isEmpty()) {
            System.out.println("No path found.");
        } else {
            System.out.println("Possible paths: " + result);
        }
    }

    static void solveMaze(int row, int col, int[][] maze, int n, boolean[][] visited, String path, List<String> result) {
        // If destination is reached
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }

        // Mark cell as visited
        visited[row][col] = true;

        // Move Down
        if (isSafe(row + 1, col, maze, visited, n)) {
            solveMaze(row + 1, col, maze, n, visited, path + "D", result);
        }
        // Move Left
        if (isSafe(row, col - 1, maze, visited, n)) {
            solveMaze(row, col - 1, maze, n, visited, path + "L", result);
        }
        // Move Right
        if (isSafe(row, col + 1, maze, visited, n)) {
            solveMaze(row, col + 1, maze, n, visited, path + "R", result);
        }
        // Move Up
        if (isSafe(row - 1, col, maze, visited, n)) {
            solveMaze(row - 1, col, maze, n, visited, path + "U", result);
        }

        // Backtrack
        visited[row][col] = false;
    }

    static boolean isSafe(int row, int col, int[][] maze, boolean[][] visited, int n) {
        return (row >= 0 && row < n && col >= 0 && col < n && maze[row][col] == 1 && !visited[row][col]);
    }
}

// Possible paths: [DRDDRR]