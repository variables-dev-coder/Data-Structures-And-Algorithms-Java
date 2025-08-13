package Queue.PriorityQueue;


/*
You are given an array of integers stones where stones[i] represents the weight of the i-th stone.
We smash stones together until at most one stone is left:
Pick the two heaviest stones.
If their weights are equal, both are destroyed.
If they are different, the lighter one is destroyed, and the heavier one is replaced with the difference in weight.
Repeat until at most one stone remains.
Return the weight of the last remaining stone. If none remain, return 0.

ex
Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
Smash 8 and 7 → new stone = 1 → [2,4,1,1,1]
Smash 4 and 2 → new stone = 2 → [2,1,1,1]
Smash 2 and 1 → new stone = 1 → [1,1,1]
Smash 1 and 1 → both destroyed → [1]
Answer = 1

 */

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        // Max-Heap: largest stone first
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the heap
        for (int stone : stones) {
            maxHeap.add(stone);
        }

        // Smash stones until <= 1 left
        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll(); // heaviest
            int stone2 = maxHeap.poll(); // second heaviest

            if (stone1 != stone2) {
                maxHeap.add(stone1 - stone2); // new stone with weight difference
            }
        }

        // If heap empty, return 0
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(lastStoneWeight(stones)); // Output: 1
    }
}



/*
Logic
Why Max Heap?
We always need the two largest stones, so a max-heap is perfect.
Java’s PriorityQueue is a min-heap by default, so we reverse it with Collections.reverseOrder().

Steps:
Insert all stones into the max-heap.
While more than 1 stone remains:
Remove the two largest stones (poll() twice).
If they are not equal, insert their difference back.
When ≤ 1 stone remains, return it (or 0 if none).


Dry Run
Input: [2, 7, 4, 1, 8, 1]
Heap initially (max-heap): [8, 7, 4, 1, 2, 1]
Pop 8 and 7 → diff = 1 → push 1 → Heap: [4, 2, 1, 1, 1]
Pop 4 and 2 → diff = 2 → push 2 → Heap: [2, 1, 1, 1]
Pop 2 and 1 → diff = 1 → push 1 → Heap: [1, 1, 1]
Pop 1 and 1 → diff = 0 → nothing to push → Heap: [1]

Final answer: 1

 */