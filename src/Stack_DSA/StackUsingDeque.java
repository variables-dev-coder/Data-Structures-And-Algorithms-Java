package Stack_DSA;


// Stack Using Deque (Best Java Practice)

import java.util.ArrayDeque;
import java.util.Deque;

public class StackUsingDeque {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.peek()); // 30
        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Now Top: " + stack.peek()); // 20
    }
}

/*
Top: 30
Popped: 30
Now Top: 20
 */