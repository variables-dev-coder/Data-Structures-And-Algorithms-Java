package Practices.Week_4;


/*
Stack Problem
Min Stack (Return Minimum in O(1) Time)

VERY IMPORTANT — asked in Amazon, Google, Microsoft, Adobe.

You must design a Stack with these operations:
    push(x)
    pop()
    top()
    getMin() → return minimum element in O(1) time

Best Approach (Two Stacks)

Maintain:

Main Stack → store actual values
Min Stack → store the minimum value at that point

When pushing:
    Push value to main stack
    If min stack empty OR x ≤ minStack.top() → push x to min stack

When popping:
    If popped element == minStack.top() → pop from minStack also

⏱ Time Complexity

| Operation | Time |
| --------- | ---- |
| push      | O(1) |
| pop       | O(1) |
| top       | O(1) |
| getMin    | O(1) |


 */
import java.util.Stack;

public class MinStack {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        mainStack.push(x);

        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public int pop() {
        int removed = mainStack.pop();

        if (removed == minStack.peek()) {
            minStack.pop();
        }

        return removed;
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack st = new MinStack();

        st.push(5);
        st.push(3);
        st.push(7);
        st.push(2);

        System.out.println("Current Min: " + st.getMin()); // 2
        st.pop();
        System.out.println("Current Min: " + st.getMin()); // 3
        st.pop();
        System.out.println("Top Element: " + st.top());    // 3
        System.out.println("Current Min: " + st.getMin()); // 3
    }
}

//Current Min: 2
//Current Min: 3
//Top Element: 3
//Current Min: 3

/*
Explanation

Push 5 → main=[5], min=[5]
Push 3 → main=[5,3], min=[5,3]
Push 7 → main=[5,3,7], min=[5,3]
Push 2 → main=[5,3,7,2], min=[5,3,2]

Min = 2

Pop 2 → remove from both stacks
Now Min = 3
 */