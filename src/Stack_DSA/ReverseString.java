package Stack_DSA;

import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String input = "Hello";
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }

        String reversed = "";
        while (!stack.isEmpty()) {

            reversed += stack.pop();
        }

        System.out.println("Reversed String: " + reversed);
    }
}
