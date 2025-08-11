package Queue.SimpleQueue;

// Given an even-sized queue, rearrange it so that the first half and second half elements are interleaved
/*
Input:  [1, 2, 3, 4, 5, 6]
Output: [1, 4, 2, 5, 3, 6]
 */

/*
Logic
-Split the queue into two halves.
-First half: [1, 2, 3]
-Second half: [4, 5, 6]
-Use another queue to store the first half temporarily.
-Alternately insert one element from the first half, then one from the second half.
 */

import java.util.LinkedList;
import java.util.Queue;

public class InterleaveQueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // fill queue
        for (int i = 1; i <= 10; i++) {
            queue.offer(i);
        }

        System.out.println("Original Queue: " + queue);

        interleaveQueue(queue);

        System.out.println("Interleaved Queue: " + queue);
    }

    public static void interleaveQueue(Queue<Integer> queue) {
        if (queue.size() % 2 != 0) {
            System.out.println("Queue size must be even!");
            return;
        }

        int halfSize = queue.size() / 2;
        Queue<Integer> firstHalf = new LinkedList<>();
        Queue<Integer> secondHalf = new LinkedList<>();


        // Step 1: Move first half into another queue
        for (int i = 0; i < halfSize; i++) {
            firstHalf.offer(queue.poll());
        }

        // step 2: Move remaining half into secondHalf queue
        while (!queue.isEmpty()){
            secondHalf.offer(queue.poll());
        }

        // Step 3: Alternately enqueue elements from both haves
        while (!firstHalf.isEmpty() && !secondHalf.isEmpty()) {
            queue.offer(firstHalf.poll());  // from first half
            queue.offer(secondHalf.poll());      // from second half
        }
    }
}
