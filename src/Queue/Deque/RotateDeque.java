package Queue.Deque;


/*
Problem Statement

Given a deque and a number k, rotate the deque elements to the right (or left) by k positions.

Example:

Input: deque = [1, 2, 3, 4, 5], k = 2, direction = right
Output: [4, 5, 1, 2, 3]

Input: deque = [1, 2, 3, 4, 5], k = 2, direction = left
Output: [3, 4, 5, 1, 2]

Approach
Right rotation → remove last element and insert at front, repeat k times.
Left rotation → remove first element and insert at last, repeat k times.

Use Deque operations:
    removeFirst() / removeLast()
    addFirst() / addLast()
 */


import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RotateDeque {
    public static void rotateRight(Deque<Integer> dq, int k) {
        int n = dq.size();
        k = k % n; // handle if k > n
        for (int i = 0; i < k; i++) {
            int val = dq.removeLast();
            dq.addFirst(val);
        }
    }

    public static void rotateLeft(Deque<Integer> dq, int k) {
        int n = dq.size();
        k = k % n;
        for (int i = 0; i < k; i++) {
            int val = dq.removeFirst();
            dq.addLast(val);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Rotate right
        rotateRight(dq, 2);
        System.out.println("Right Rotate: " + dq);

        // Reset deque
        dq = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Rotate left
        rotateLeft(dq, 2);
        System.out.println("Left Rotate: " + dq);
    }
}

/*
Dry Run (Right Rotate Example)

Initial: [1, 2, 3, 4, 5]
Step 1 → removeLast=5 → addFirst → [5, 1, 2, 3, 4]
Step 2 → removeLast=4 → addFirst → [4, 5, 1, 2, 3]
Output → [4, 5, 1, 2, 3]

 */