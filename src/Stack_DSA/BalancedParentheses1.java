package Stack_DSA;


/*
Problem:
Check if a string of brackets is balanced (open and close brackets match in order).
-Input: "{[()]}"
-Output: true
-Input: "{[(])}"
-Output: false
 */

/*
Logic:
-Use a stack to store opening brackets.
-When encountering a closing bracket, check if the stack’s top matches.
-If mismatch or stack is empty when closing bracket comes, return false.
-Finally, if stack is empty → balanced.
 */

import java.util.Stack;

public class BalancedParentheses1 {

    public static boolean isBalanced(String expr) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expr.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("{[()]}")); // true
        System.out.println(isBalanced("{[(]]}"));  // false
    }
}

/*

| Char | Stack   | Action         |
| ---- | ------- | -------------- |
| `{`  | `{`     | push `{`       |
| `[`  | `{ [`   | push `[`       |
| `(`  | `{ [ (` | push `(`       |
| `)`  | `{ [`   | match `(`, pop |
| `]`  | `{`     | match `[`, pop |
| `}`  | empty   | match `{`, pop |

 */