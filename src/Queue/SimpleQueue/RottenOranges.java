package Queue.SimpleQueue;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static class Point {
        int x, y, time;
        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Point> queue = new LinkedList<>();
        int freshCount = 0;

        // Step 1: Add rotten oranges to queue & count fresh
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Point(i, j, 0));
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        // Directions: up, down, left, right
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int time = 0;

        // Step 2: BFS
        while (!queue.isEmpty()) {
            Point curr = queue.poll();
            time = curr.time;

            for (int[] dir : directions) {
                int newX = curr.x + dir[0];
                int newY = curr.y + dir[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols
                        && grid[newX][newY] == 1) {

                    grid[newX][newY] = 2; // make it rotten
                    freshCount--;
                    queue.offer(new Point(newX, newY, curr.time + 1));
                }
            }
        }

        return freshCount == 0 ? time : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println("Minutes until all oranges rot: " + orangesRotting(grid));
    }
}

/*
Problem
We are given an m x n grid:
0 → Empty cell
1 → Fresh orange
2 → Rotten orange

Every minute, any fresh orange that is adjacent (up, down, left, right) to a rotten orange becomes rotten.
We need to return the minimum minutes until all oranges are rotten.
If it’s impossible, return -1.

Logic (BFS using Queue)
Why BFS?
Because rotting spreads level by level (minute by minute) — perfect for BFS traversal.

Steps:
1. Count total fresh oranges.
2. Push all rotten oranges’ positions into the queue with time = 0.
3. While queue is not empty:
    Pop the front element (position + time).
    Check its 4 neighbors.
    If a neighbor is a fresh orange:
        Make it rotten.
        Push it into the queue with time + 1.
        Reduce the fresh count.
4. If fresh count becomes 0 → return last time value.
5. If fresh > 0 after BFS → return -1.
 */

/*

Dry Run
Example:

2 1 1
1 1 0
0 1 1

Initially rotten = (0,0)
Minute 1: (0,1), (1,0) rot
Minute 2: (0,2), (1,1), (2,1) rot
Minute 3: (2,2) rots → Done
Output = 4


 */