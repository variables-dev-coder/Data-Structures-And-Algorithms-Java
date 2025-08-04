package Stack_DSA;

import java.util.Stack;

public class IsEmptyExample {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();

        System.out.println("Is Stack Empty? " + stack.isEmpty());   // Is Stack Empty? true

        stack.push('A');
        System.out.println("Is Stack Empty now? " + stack.isEmpty());   // Is Stack Empty now? false
    }
}
