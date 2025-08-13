package Queue.PriorityQueue;


/*
Problem 8: Connect N Ropes with Minimum Cost (LeetCode #1167)
You are given n ropes of different lengths. You need to connect these ropes into one rope.
The cost to connect two ropes is equal to the sum of their lengths.
You need to connect the ropes in such a way that the total cost is minimized.

Input: ropes = [4, 3, 2, 6]
Output: 29
Explanation:
1. Connect ropes 2 and 3 → cost = 5, new ropes = [4, 5, 6]
2. Connect ropes 4 and 5 → cost = 9, new ropes = [9, 6]
3. Connect ropes 6 and 9 → cost = 15, new ropes = [15]
Total cost = 5 + 9 + 15 = 29

Logic
The best way to minimize cost is to always connect the two smallest ropes first.
A Min Heap (Java PriorityQueue) will help us efficiently get the smallest ropes each time.

Steps:
1.Insert all rope lengths into a min heap.
2.While more than one rope remains:
    Remove the two smallest ropes (min1, min2).
    Cost to connect = min1 + min2.
    Add the cost to totalCost.
    Insert the combined rope back into the heap.
4.The totalCost is the answer.
 */

import java.util.PriorityQueue;

public class ConnectRopes {
    public static int minCost(int[] ropes) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Add all ropes to min heap
        for (int rope : ropes) {
            minHeap.add(rope);
        }

        int totalCost = 0;

        // Keep combining the two smallest ropes
        while (minHeap.size() > 1) {
            int min1 = minHeap.poll();
            int min2 = minHeap.poll();

            int cost = min1 + min2;
            totalCost += cost;

            minHeap.add(cost); // Insert new rope back into heap
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] ropes = {4, 3, 2, 6};
        System.out.println("Minimum cost to connect ropes: " + minCost(ropes));
    }
}


/*
Min Heap: [2, 3, 4, 6]
Step 1: Take 2, 3 → cost = 5 → totalCost = 5 → heap = [4, 5, 6]
Step 2: Take 4, 5 → cost = 9 → totalCost = 14 → heap = [6, 9]
Step 3: Take 6, 9 → cost = 15 → totalCost = 29 → heap = [15]
End: totalCost = 29


 */