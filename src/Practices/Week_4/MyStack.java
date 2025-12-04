package Practices.Week_4;

/*
Queue Problem
-------------
Implement Stack Using Two Queues
(Asked in Amazon, Microsoft, Flipkart)

A Stack follows LIFO (Last In First Out).
But we must implement it using two Queues (FIFO).

Algorithm — Push Costly Method
------------------------------
Use two queues: q1 and q2

push(x):
1.Add x to q2
2.Move all elements from q1 → q2
3.Swap q1 and q2
    Now the newest element is always at the front of q1

pop():
Remove from q1

top():
Return front of q1

empty():
Check if q1 is empty

Time Complexity

| Operation | Time |
| --------- | ---- |
| push      | O(n) |
| pop       | O(1) |
| top       | O(1) |
| empty     | O(1) |

 */


import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    /** Push element x onto stack. */
    public void push(int x) {
        q2.add(x);

        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    /** Removes the element from on top of the stack. */
    public int pop() {
        return q1.remove();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.top()); // 30
        System.out.println("Pop: " + stack.pop()); // 30
        System.out.println("Top: " + stack.top()); // 20
    }
}

//Top: 30
//Pop: 30
//Top: 20

/*
Explanation
push(10)

q1 = {10}

push(20)

q2 = {20}
move q1 → q2 → {20,10}
swap → q1 = {20,10}

push(30)

q2 = {30}
move q1 → q2 → {30,20,10}
swap → q1 = {30,20,10}

Top = 30
Pop = 30
 */