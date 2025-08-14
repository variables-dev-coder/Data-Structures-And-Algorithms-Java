package Queue.Deque;

/*
Problem Statement

Given an array of points in the 2D plane, where each point is represented as [x, y],
and an integer k, return the k closest points to the origin (0, 0).
The distance between two points on a plane is the Euclidean distance:

distance = √(root) x2+y2

points = [[1,3],[-2,2],[5,8],[0,1]]
k = 2

[[-2,2],[0,1]]

Explanation:
Distances:
(1,3) → √(1² + 3²) = √10 ≈ 3.16
(-2,2) → √(4 + 4) = √8 ≈ 2.83
(5,8) → √(25 + 64) = √89 ≈ 9.43
(0,1) → √(0 + 1) = 1.0

The 2 smallest distances are from (-2,2) and (0,1).

Logic
1.We don’t need the exact square root for comparison; squared distance is enough (to save computation).
2.Use a Max Heap of size k to store the closest points.
3.Iterate over each point:
    Calculate squared distance from origin.
    Push into Max Heap with distance as key.
    If heap size exceeds k, remove the farthest point.
4.After iterating, the heap contains the k closest points.

 */




import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPoints {
    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
                (a, b) -> (distance(b) - distance(a)) // max-heap based on distance
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll(); // remove farthest
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    private static int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        int[][] closest = kClosest(points, k);

        for (int[] p : closest) {
            System.out.println(Arrays.toString(p));
        }
    }
}



/*
Dry Run
For points = [[1,3],[-2,2],[5,8],[0,1]], k = 2:

| Step | Point  | Dist² | Heap                             |
| ---- | ------ | ----- | -------------------------------- |
| 1    | (1,3)  | 10    | \[(1,3)]                         |
| 2    | (-2,2) | 8     | \[(1,3), (-2,2)]                 |
| 3    | (5,8)  | 89    | remove (5,8) → keep closest 2    |
| 4    | (0,1)  | 1     | remove (1,3) → keep (-2,2),(0,1) |

Final answer → (-2,2) and (0,1).
 */