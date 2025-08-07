package Stack_DSA;

// Problem:
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Logic:
//Maintain two stacks: main stack and a min stack.
//Push element into main stack.
//Push to min stack only if it’s <= current min.

import java.util.Stack;

class MinStack2 {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
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

public class MinStackExample {
    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(5);
        s.push(2);
        s.push(8);

        System.out.println("Min: " + s.getMin()); // 2
        s.pop();
        System.out.println("Min after pop: " + s.getMin()); // 2
    }

}

/*
push(5) → stack: [5], min: [5]
push(2) → stack: [5,2], min: [5,2]
push(8) → stack: [5,2,8], min: [5,2]
pop()   → removes 8, min still 2
getMin() → 2

 */