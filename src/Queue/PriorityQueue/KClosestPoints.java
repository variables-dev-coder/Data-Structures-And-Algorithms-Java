package Queue.PriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoints {
    public static int[][] kClosest(int[][] points, int k) {
        // Max Heap based on distance from origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> (distance(b) - distance(a))
        );

        for (int[] point : points) {
            maxHeap.offer(point); // Add point
            if (maxHeap.size() > k) {
                maxHeap.poll(); // Remove farthest
            }
        }

        // Extract k closest points
        int[][] result = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            result[index++] = maxHeap.poll();
        }
        return result;
    }

    // Helper function to calculate squared distance
    private static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {
        int[][] points1 = {{1, 3}, {-2, 2}};
        int[][] ans1 = kClosest(points1, 1);
        System.out.println(Arrays.deepToString(ans1)); // [[-2, 2]]

        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int[][] ans2 = kClosest(points2, 2);
        System.out.println(Arrays.deepToString(ans2)); // [[3, 3], [-2, 4]]
    }
}

/*
[[-2, 2]]
[[-2, 4], [3, 3]]


Dry Run (Example 1)
Input: [[1,3], [-2,2]], k=1
Add (1,3) → Heap = [(1,3)]
Add (-2,2) → Heap = [(1,3), (-2,2)]
Distances: (1,3) = 10, (-2,2) = 8
Remove farthest → Remove (1,3)
Heap now has closest point: [(-2,2)]


Logic
We need the k closest points.
Use a max heap (PriorityQueue with custom comparator) to store points by distance from origin.
Keep heap size at most k — if size exceeds, remove the farthest point.
Return all points from the heap.


 */