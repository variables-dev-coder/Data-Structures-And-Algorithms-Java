package Stack_DSA;

import java.util.Stack;

public class PeekExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        stack.push("Java");
        stack.push("Spring");
        stack.push("MySQL");

        System.out.println("Top Element: " + stack.peek());  // Top Element: MySQL
    }
}
