package Stack_DSA;

import java.util.Stack;

public class StackSizeClear {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack size: " + stack.size()); // 3
        stack.clear();
        System.out.println("Is stack empty? " + stack.isEmpty()); // true
    }
}
