package Queue.CircularQueue;


/*
Concept
-We have a queue, and we want to print its elements in a circular fashion.
-The original order must remain unchanged after printing.
-This means we can’t just dequeue elements and lose them — we either:
    1. Use a temporary copy of the queue.
    2. Or use the queue itself but reinsert elements after dequeuing.

Example
Queue: 10, 20, 30, 40
Circular Order (starting from 10):
10 → 20 → 30 → 40 → 10 → 20 → ... (repeat as needed)

If we only want one circular pass, it’s the same as the normal print.
If we want multiple rotations, we just keep printing elements in a loop, wrapping around.


 */
import java.util.LinkedList;
import java.util.Queue;

public class CircularQueuePrinter {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);

        System.out.println("Original Queue: " + queue);

        printCircular(queue, 2); // print 2 full circular passes
    }

    public static void printCircular(Queue<Integer> queue, int rotations) {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        int size = queue.size();

        for (int i = 0; i < size * rotations; i++) {
            int element = queue.poll(); // remove front
            System.out.print(element + " "); // print
            queue.add(element); // re-add to maintain order
        }

        System.out.println("\nQueue after printing: " + queue);
    }
}

/*
How It Works
1.poll() removes the front element.
2.We print it.
3.Then add() puts it back at the rear.
4.This way, after all rotations, the queue’s original order is restored.

Original Queue: [10, 20, 30, 40]
10 20 30 40 10 20 30 40
Queue after printing: [10, 20, 30, 40]

 */