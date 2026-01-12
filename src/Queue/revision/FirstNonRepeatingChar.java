package Queue.revision;

import java.util.LinkedList;
import java.util.Queue;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {

        String stream = "aabc";
        int[] freq = new int[26];
        Queue<Character> q = new LinkedList<>();

        for (char ch : stream.toCharArray()) {
            freq[ch - 'a']++;
            q.add(ch);

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.poll();
            }

            if (q.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }
}

