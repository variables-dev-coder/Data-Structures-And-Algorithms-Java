package revision3;

import java.util.*;

public class ShortestPathBinaryMatrix {

    public static int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        // If start or end blocked
        if (grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;

        int[][] directions = {
                {-1,-1}, {-1,0}, {-1,1},
                {0,-1},          {0,1},
                {1,-1},  {1,0},  {1,1}
        };

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1}); // row, col, distance

        grid[0][0] = 1; // mark visited

        while (!queue.isEmpty()) {

            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], dist = curr[2];

            // Reached destination
            if (r == n - 1 && c == n - 1) return dist;

            for (int[] dir : directions) {

                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0) {

                    queue.offer(new int[]{nr, nc, dist + 1});
                    grid[nr][nc] = 1; // mark visited
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[][] grid = {
                {0,1},
                {1,0}
        };

        int result = shortestPathBinaryMatrix(grid);

        System.out.println("Shortest Path: " + result);
    }
}
