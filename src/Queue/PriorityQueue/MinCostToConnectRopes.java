package Queue.PriorityQueue;


/*
Problem 9: Minimum Cost to Connect Ropes
You are given n ropes of different lengths. You need to connect them into one rope.
The cost to connect two ropes is equal to the sum of their lengths.
Find the minimum total cost to connect all ropes.

ex
Input: ropes = [4, 3, 2, 6]
Output: 29
Explanation:
1. Connect ropes of length 2 and 3 → Cost = 5 → ropes = [4, 5, 6]
2. Connect ropes of length 4 and 5 → Cost = 9 → ropes = [9, 6]
3. Connect ropes of length 6 and 9 → Cost = 15 → ropes = [15]
Total cost = 5 + 9 + 15 = 29


Logic
Always connect the two smallest ropes first to minimize cost.
This is a greedy algorithm problem.
Use PriorityQueue (min-heap) to get smallest ropes quickly.

 */

import java.util.PriorityQueue;

public class MinCostToConnectRopes {
    public static int minCost(int[] ropes) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all ropes to the min-heap
        for (int rope : ropes) {
            pq.offer(rope);
        }

        int totalCost = 0;

        // Keep combining until one rope remains
        while (pq.size() > 1) {
            int first = pq.poll(); // smallest
            int second = pq.poll(); // second smallest
            int cost = first + second;
            totalCost += cost;
            pq.offer(cost); // add the combined rope back
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        System.out.println("Minimum cost: " + minCost(ropes));
    }
}

/*
Ropes = [4, 3, 2, 6]
PQ = [2, 3, 4, 6]

1st: Take 2, 3 → Cost = 5 → PQ = [4, 5, 6]
2nd: Take 4, 5 → Cost = 9 → PQ = [6, 9]
3rd: Take 6, 9 → Cost = 15 → PQ = [15]
Total = 5 + 9 + 15 = 29

 */