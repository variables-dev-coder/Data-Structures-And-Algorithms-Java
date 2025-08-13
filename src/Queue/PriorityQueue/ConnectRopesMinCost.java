package Queue.PriorityQueue;


/*
Description:
You are given n ropes of different lengths. You need to connect the ropes into one rope.
The cost of connecting two ropes is equal to the sum of their lengths.
Find the minimum cost to connect all ropes.

ex
Input: ropes = [4, 3, 2, 6]
Output: 29
Explanation:
First connect 2 and 3 → cost = 5, ropes = [4, 5, 6]
Then connect 4 and 5 → cost = 9, ropes = [9, 6]
Then connect 9 and 6 → cost = 15
Total cost = 5 + 9 + 15 = 29


Logic
Always pick the two smallest ropes first (because combining smaller ones earlier reduces future costs).
Use a min-heap (PriorityQueue in Java) to efficiently get the two smallest ropes.
Keep adding the cost until only one rope remains.

 */

import java.util.PriorityQueue;

public class ConnectRopesMinCost {
    public static int minCost(int[] ropes) {
        // Min-heap to store rope lengths
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all ropes to heap
        for (int rope : ropes) {
            pq.add(rope);
        }

        int totalCost = 0;

        // Combine until one rope remains
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int cost = first + second;
            totalCost += cost;
            pq.add(cost); // Add back combined rope
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        System.out.println("Minimum Cost: " + minCost(ropes));
    }
}

/*
Dry Run
Initial heap: [2, 3, 4, 6]
Take 2 & 3 → cost = 5 → heap: [4, 5, 6] → total = 5
Take 4 & 5 → cost = 9 → heap: [6, 9] → total = 14
Take 6 & 9 → cost = 15 → heap: [15] → total = 29

Output: 29


 */