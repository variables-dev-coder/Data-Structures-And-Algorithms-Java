package Practices.Week_3;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstNonRepeatingInStream {
    public static void processStream(String s) {
        int[] freq = new int[256];
        Deque<Character> q = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            freq[c]++;
            q.offer(c);
            while (!q.isEmpty() && freq[q.peek()] > 1) q.poll();
            System.out.print((q.isEmpty() ? '#' : q.peek()) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        processStream("aabc");
        // output: a # b b
        // after 'a' -> first non repeating 'a'
        // after second 'a' -> none => #
        // after 'b' -> 'b'
        // after 'c' -> 'b' (still non repeating)
    }
}

// a # b b