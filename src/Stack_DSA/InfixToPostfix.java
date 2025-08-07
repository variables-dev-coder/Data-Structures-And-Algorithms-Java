package Stack_DSA;

/*
Infix to Postfix Conversion
Problem:
Convert expression like (A+B)*C to Postfix → AB+C*
Logic:
Use stack to store operators and follow operator precedence:
If character is operand → add to result
If operator:
Pop from stack while top has higher or equal precedence
Then push current operator
 */

import java.util.Stack;

public class InfixToPostfix {
    static int precedence(char ch) {
        if (ch == '+' || ch == '-') return 1;
        if (ch == '*' || ch == '/') return 2;
        return -1;
    }

    public static String convert(String exp) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char ch : exp.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (stack.peek() != '(') result.append(stack.pop());
                stack.pop(); // pop '('
            } else { // operator
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) result.append(stack.pop());
        return result.toString();
    }

    public static void main(String[] args) {
        String infix = "(A+B)*C";
        System.out.println(convert(infix)); // AB+C*
    }
}

/*
| Char | Stack | Output    |
| ---- | ----- | --------- |
| `(`  | `(`   |           |
| `A`  | `(`   | `A`       |
| `+`  | `(+`  | `A`       |
| `B`  | `(+`  | `AB`      |
| `)`  |       | `AB+`     |
| `*`  | `*`   | `AB+`     |
| `C`  | `*`   | `AB+C`    |
| End  |       | `AB+C*`   |

 */