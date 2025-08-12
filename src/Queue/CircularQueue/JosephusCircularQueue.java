package Queue.CircularQueue;


/*
Problem Statement
You have n people standing in a circle, numbered from 1 to n. Starting from person 1,
you count k people clockwise, and the k-th person is eliminated.
The counting resumes from the next person after the eliminated one, and this continues
until only one person remains.

Your task: Find the position of the last remaining person.
 */
import java.util.LinkedList;
import java.util.Queue;

public class JosephusCircularQueue {
    public static int josephus(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();

        // Add all people into the queue
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // Process until only one person remains
        while (queue.size() > 1) {
            // Move first (k-1) people to the back of the queue
            for (int i = 1; i < k; i++) {
                queue.add(queue.poll());
            }
            // Remove the k-th person
            System.out.println("Eliminated: " + queue.poll());
        }

        // Last person remaining is the winner
        return queue.peek();
    }

    public static void main(String[] args) {
        int n = 7, k = 3;
        int winner = josephus(n, k);
        System.out.println("Winner is: " + winner);
    }
}

/*
Dry Run for n = 7, k = 3
Queue: 1 2 3 4 5 6 7
Move 1 2 → Back, remove 3 → Queue: 4 5 6 7 1 2
Move 4 5 → Back, remove 6 → Queue: 7 1 2 4 5
Move 7 1 → Back, remove 2 → Queue: 4 5 7 1
Move 4 5 → Back, remove 7 → Queue: 1 4 5
Move 1 4 → Back, remove 5 → Queue: 4 1
Move 4 1 → Back, remove 1 → Queue: 4
Winner: 4

Real-life uses:
Scheduling round-robin processes in operating systems.
Multiplayer game elimination rounds.
Network token passing.

ex
n = 7, k = 3
People: 1 2 3 4 5 6 7

Step 1: Count 3 → Person 3 eliminated → Remaining: 1 2 4 5 6 7
Step 2: Count 3 → Person 6 eliminated → Remaining: 1 2 4 5 7
Step 3: Count 3 → Person 2 eliminated → Remaining: 1 4 5 7
Step 4: Count 3 → Person 7 eliminated → Remaining: 1 4 5
Step 5: Count 3 → Person 5 eliminated → Remaining: 1 4
Step 6: Count 3 → Person 1 eliminated → Remaining: 4 (Winner)

 */