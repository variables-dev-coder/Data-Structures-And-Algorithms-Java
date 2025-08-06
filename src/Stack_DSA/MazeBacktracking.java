package Stack_DSA;

// Backtracking – Solving a Maze (Path from top-left to bottom-right)

public class MazeBacktracking {
    public static boolean solveMaze(int[][] maze, int row, int col) {
        int n = maze.length;

        // base condition
        if (row == n - 1 && col == n - 1) {
            maze[row][col] = 9; // part of the path
            return true;
        }

        if (row < n && col < n && maze[row][col] == 1) {
            maze[row][col] = 9; // mark visited path

            // move right
            if (solveMaze(maze, row, col + 1)) return true;

            // move down
            if (solveMaze(maze, row + 1, col)) return true;

            // backtrack
            maze[row][col] = 1;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0},
                {1, 1, 0},
                {0, 1, 1}
        };

        solveMaze(maze, 0, 0);

        for (int[] row : maze) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}

/*

9 0 0
9 9 0
0 9 9

 */