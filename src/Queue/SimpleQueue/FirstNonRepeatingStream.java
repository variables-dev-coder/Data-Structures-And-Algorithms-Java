package Queue.SimpleQueue;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingStream {
    public static void firstNonRepeating(String stream) {
        int[] freq = new int[26]; // frequency of characters
        Queue<Character> q = new LinkedList<>();

        for (char ch : stream.toCharArray()) {
            // Update frequency
            freq[ch - 'a']++;

            // Add to queue
            q.offer(ch);

            // Remove all repeating characters from the front
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            // Output result
            if (q.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }

    public static void main(String[] args) {
        String input = "aabc";
        System.out.println("Input: " + input);
        System.out.print("Output: ");
        firstNonRepeating(input);
    }
}

// Input: aabc
//Output: a -1 b b

/*
You are given a stream of lowercase characters.
At each step, you need to find the first non-repeating character from the stream so far.
If there is none, output -1.

Example
Input:  a a b c
Output: a -1 b b

First 'a' → first non-repeating is 'a'
Second 'a' → 'a' repeats → no unique → -1
Add 'b' → first non-repeating is 'b'
Add 'c' → first non-repeating is still 'b'

Logic
We can solve this using:
Queue → To maintain the order of characters.
Frequency array (size 26) → To track counts of each character.

Steps:
For each new character:
Increment its frequency.
Add it to the queue.
While queue front has frequency > 1, remove it (repeated character).
If queue is empty → output -1, else → output queue front.

 */