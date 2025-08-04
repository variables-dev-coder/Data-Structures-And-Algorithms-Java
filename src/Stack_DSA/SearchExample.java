package Stack_DSA;

import java.util.Stack;

public class SearchExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.push("Four");

        System.out.println("Position of 'Two': " + stack.search("Two")); // 3
        System.out.println("Position of 'Five': " + stack.search("Five")); // -1
    }
}
