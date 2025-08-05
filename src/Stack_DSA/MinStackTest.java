package Stack_DSA;


// Min Stack (with constant-time getMin())

import java.util.Stack;

class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek())
            minStack.push(val);
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

public class MinStackTest {
    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(3);
        s.push(5);
        s.push(2);
        s.push(1);
        System.out.println("Min: " + s.getMin()); // 1
        s.pop();
        System.out.println("Min after pop: " + s.getMin()); // 2
    }
}

// Min: 1
//Min after pop: 2