package revision11;

import java.util.Stack;

public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {

                stack.push(i);

            } else {

                stack.pop();

                if (stack.isEmpty()) {

                    stack.push(i);

                } else {

                    maxLength =
                            Math.max(
                                    maxLength,
                                    i - stack.peek()
                            );
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {

        String s = ")()())";

        System.out.println(
                longestValidParentheses(s)
        );
    }
}
