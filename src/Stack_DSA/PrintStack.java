package Stack_DSA;

import java.util.Stack;

public class PrintStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        stack.push(500);

        for (int value : stack) {
            System.out.println(value);
        }
    }
}
