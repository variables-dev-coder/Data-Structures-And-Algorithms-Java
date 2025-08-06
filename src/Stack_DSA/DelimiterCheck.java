package Stack_DSA;

// Delimiter Checking – Balanced Parentheses

import java.util.Stack;

public class DelimiterCheck {
    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if ((ch == ')' && open != '(') ||
                        (ch == '}' && open != '{') ||
                        (ch == ']' && open != '[')) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String input = "{[()]}";
        System.out.println("Balanced: " + isBalanced(input)); // true
    }
}
