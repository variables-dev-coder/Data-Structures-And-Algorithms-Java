package Revision.Day_5_Queue;

import java.util.*;

public class ReverseQueue {
    static void reverse(Queue<Integer> q) {
        if (q.isEmpty()) return;
        int x = q.poll();
        reverse(q);
        q.add(x);
    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        System.out.println("Original Queue: " + q);
        reverse(q);
        System.out.println("Reversed Queue: " + q);
    }
}

//Original Queue: [1, 2, 3, 4]
//Reversed Queue: [4, 3, 2, 1]