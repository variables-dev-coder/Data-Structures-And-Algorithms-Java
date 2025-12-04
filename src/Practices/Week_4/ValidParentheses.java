package Practices.Week_4;

/*
Stack Problem
-------------
Valid Parentheses (Most asked by Amazon, Google, Microsoft)

Given a string containing brackets () {} [], determine if it's valid.

A string is valid if:
    1.Open brackets are closed by the same type
    2.They close in correct order
    3.Every close bracket has a previous matching open bracket

Algorithm
---------
1.Use a Stack<Character>
2.Traverse the string:
    If char is opening → push to stack
    If char is closing →
        If stack empty → invalid
        If top of stack does NOT match → invalid
        Else pop stack
3.At the end, if stack is empty → valid

Time: O(n)
Space: O(n)

 */


import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if (ch == ')' && top != '(') return false;
                if (ch == '}' && top != '{') return false;
                if (ch == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "{[()]}";

        System.out.println("Is valid? " + isValid(s));
    }
}

//Is valid? true

/*
Explanation
String:
{ [ ( ) ] }
Process:
{ → push
[ → push
( → push
) → matches ( → pop
] → matches [ → pop
} → matches { → pop

Stack empty → valid
 */