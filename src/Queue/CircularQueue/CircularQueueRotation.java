package Queue.CircularQueue;

/*
Problem Statement
You have a circular queue with n positions numbered 1 to n.
You start at a given start position and perform k rotations (each rotation moves you to the next position).
Find the final position after k rotations.

ex
n = 5, start = 3, k = 8

Explanation:
Positions: 1 → 2 → 3 → 4 → 5 → (wrap around) → 1 → ...
From position 3:

Move 1: 4
Move 2: 5
Move 3: 1
Move 4: 2
Move 5: 3
Move 6: 4
Move 7: 5
Move 8: 1

o/p 1

Logic
Since the queue is circular, after the last position, we wrap to position 1.

This is a modulo problem:

finalPos
=((𝑠𝑡𝑎𝑟𝑡−1+𝑘)%𝑛)+1
finalPos=((start−1+k)%n)+1

Where:
start - 1 makes it 0-based index.
% n handles the circular wrap.
+ 1 converts back to 1-based position.

 */
public class CircularQueueRotation {
    public static int findFinalPosition(int n, int start, int k) {
        return ((start - 1 + k) % n) + 1;
    }

    public static void main(String[] args) {
        int n = 5;      // total positions in circular queue
        int start = 3;  // starting position
        int k = 8;      // rotations

        int finalPos = findFinalPosition(n, start, k);

        System.out.println("Final Position: " + finalPos);
    }
}

/*
Dry Run
n = 5, start = 3, k = 8
Step 1: start - 1 = 2
Step 2: 2 + 8 = 10
Step 3: 10 % 5 = 0
Step 4: 0 + 1 = 1 → Final Position

Real-Time Use Cases
In round-robin scheduling in OS.
Multiplayer game turn system.
Rotating buffer pointers in hardware queues.

 */