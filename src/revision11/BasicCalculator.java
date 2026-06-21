package revision11;

import java.util.Stack;

public class BasicCalculator {

    public static int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                number = 0;

                while (i < s.length()
                        && Character.isDigit(s.charAt(i))) {

                    number = number * 10
                            + (s.charAt(i) - '0');

                    i++;
                }

                i--;

                result += sign * number;
            }

            else if (ch == '+') {

                sign = 1;
            }

            else if (ch == '-') {

                sign = -1;
            }

            else if (ch == '(') {

                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;
            }

            else if (ch == ')') {

                int previousSign = stack.pop();
                int previousResult = stack.pop();

                result =
                        previousResult
                                +
                                previousSign * result;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        String expression =
                "(1+(4+5+2)-3)+(6+8)";

        System.out.println(
                calculate(expression)
        );
    }
}
