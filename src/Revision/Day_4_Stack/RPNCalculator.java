package Revision.Day_4_Stack;

import java.util.Stack;

public class RPNCalculator {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] exp1 = {"2", "1", "+", "3", "*"};
        System.out.println("Result 1: " + evalRPN(exp1)); // Output: 9

        String[] exp2 = {"4", "13", "5", "/", "+"};
        System.out.println("Result 2: " + evalRPN(exp2)); // Output: 6
    }
}

//Result 1: 9
//Result 2: 6