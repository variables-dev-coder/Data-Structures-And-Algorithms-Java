package Stack_DSA;

// Reverse Stack Recursively

import java.util.Stack;

public class ReverseStack {
    public static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, item);
        stack.push(top);
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int top = stack.pop();
        reverse(stack);
        insertAtBottom(stack, top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        reverse(stack);

        System.out.println("Reversed Stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

// Reversed Stack:
//1
//2
//3
//4