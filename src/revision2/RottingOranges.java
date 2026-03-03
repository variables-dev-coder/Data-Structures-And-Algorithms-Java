package revision2;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // Step 1: Collect all rotten oranges & count fresh
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int minutes = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        // Step 2: BFS
        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean rottedThisMinute = false;

            for (int i = 0; i < size; i++) {

                int[] cell = queue.poll();

                for (int[] dir : directions) {

                    int newRow = cell[0] + dir[0];
                    int newCol = cell[1] + dir[1];

                    if (newRow >= 0 && newCol >= 0 &&
                            newRow < rows && newCol < cols &&
                            grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        queue.offer(new int[]{newRow, newCol});
                        fresh--;
                        rottedThisMinute = true;
                    }
                }
            }

            if (rottedThisMinute) minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };

        System.out.println(orangesRotting(grid)); // Output: 4
    }
}
