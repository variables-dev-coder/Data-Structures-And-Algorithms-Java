package Stack_DSA;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack: " + stack); // [10, 20, 30]

        // Peek (top element)
        System.out.println("Top element: " + stack.peek()); // 30

        // Pop
        System.out.println("Popped: " + stack.pop()); // 30

        // After pop
        System.out.println("Stack after pop: " + stack); // [10, 20]

        // isEmpty
        System.out.println("Is stack empty? " + stack.isEmpty()); // false

        // Size
        System.out.println("Size of stack: " + stack.size()); // 2
    }
}
