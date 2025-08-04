package Stack_DSA;

import java.util.Stack;

public class PushPopExample {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(5);
        stack.push(10);
        stack.push(15);
        stack.push(20);

        System.out.println("Stack: " + stack);

        int popped = stack.pop();
        System.out.println("Popped Element: " + popped);
        System.out.println("Stack After Pop: " + stack);
    }
}
