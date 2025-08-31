package Revision.Day_4_Stack;

import java.util.Stack;

public class PostfixEvaluation {
    public static int evaluatePostfix(String exp) {
        Stack<Integer> stack = new Stack<>();

        for (char ch : exp.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch - '0'); // convert char to int
            } else {
                int val2 = stack.pop();
                int val1 = stack.pop();
                switch (ch) {
                    case '+': stack.push(val1 + val2); break;
                    case '-': stack.push(val1 - val2); break;
                    case '*': stack.push(val1 * val2); break;
                    case '/': stack.push(val1 / val2); break;
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String exp = "231*+9-";
        System.out.println("Result: " + evaluatePostfix(exp));
    }
}

//Result: -4