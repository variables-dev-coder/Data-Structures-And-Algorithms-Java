package Practices.Week_3;

//MinStack

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {
    Deque<Integer> main = new ArrayDeque<>();
    Deque<Integer> mins = new ArrayDeque<>();

    public void push(int x) {
        main.push(x);
        if (mins.isEmpty() || x <= mins.peek()) mins.push(x);
    }
    public void pop() {
        int v = main.pop();
        if (v == mins.peek()) mins.pop();
    }
    public int top() { return main.peek(); }
    public int getMin() { return mins.peek(); }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(3); s.push(5); s.push(2);
        System.out.println(s.getMin()); // 2
        s.pop();
        System.out.println(s.getMin()); // 3
    }
}
