package queue_Deque;

import java.util.*;

public class DequeExample {

    public static void main(String[] args) {

        Deque<Integer> deque = new ArrayDeque<>();

        deque.addFirst(20);
        deque.addFirst(10);

        deque.addLast(30);
        deque.addLast(40);

        System.out.println(deque);

        System.out.println("First: " + deque.peekFirst());
        System.out.println("Last: " + deque.peekLast());

        System.out.println("Removed First: "
                + deque.removeFirst());

        System.out.println("Removed Last: "
                + deque.removeLast());

        System.out.println(deque);
    }
}
