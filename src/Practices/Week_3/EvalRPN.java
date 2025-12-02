package Practices.Week_3;

//EvalRPN

import java.util.ArrayDeque;
import java.util.Deque;

public class EvalRPN {
    public static int evalRPN(String[] tokens) {
        Deque<Integer> st = new ArrayDeque<>();
        for (String t : tokens) {
            if ("+-*/".contains(t)) {
                int b = st.pop();
                int a = st.pop();
                int res = 0;
                switch (t) {
                    case "+": res = a + b; break;
                    case "-": res = a - b; break;
                    case "*": res = a * b; break;
                    case "/": res = a / b; break;
                }
                st.push(res);
            } else st.push(Integer.parseInt(t));
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"}; // (2+1)*3 = 9
        System.out.println(evalRPN(tokens)); // 9
    }
}
