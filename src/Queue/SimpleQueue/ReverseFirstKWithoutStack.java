package Queue.SimpleQueue;


// Reverse First K Elements of Queue without using a Stack — only queue operations.

// Logic (Only Queue Rotation)
//We can reverse the first k elements by:
//Remove the first k elements and store them in an array/list.
//Reverse that array/list.
//Add them back to the queue.
//Then rotate the remaining elements to the back so the order stays correct.


import java.util.*;

public class ReverseFirstKWithoutStack {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 5; i++) {
            queue.add(i);
        }
        int k = 3;

        System.out.println("Original Queue: " + queue);
        reverseFirstK(queue, k);
        System.out.println("Modified Queue: " + queue);
    }

    public static void reverseFirstK(Queue<Integer> queue, int k) {
        if (queue.isEmpty() || k <= 0 || k > queue.size()) {
            return;
        }

        // Step 1: Remove first k elements into list
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            tempList.add(queue.poll());
        }

        // Step 2: Reverse the list
        Collections.reverse(tempList);

        // Step 3: Add reversed elements back to queue
        for (int num : tempList) {
            queue.add(num);
        }

        // Step 4: Rotate the remaining elements
        int size = queue.size();
        for (int i = 0; i < size - k; i++) {
            queue.add(queue.poll());
        }
    }
}

// Queue = [1, 2, 3, 4, 5], k = 3

// Take first k → [1, 2, 3]
//Reverse → [3, 2, 1]
//Add to queue → [3, 2, 1, 4, 5]