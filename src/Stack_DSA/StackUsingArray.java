package Stack_DSA;

public class StackUsingArray {
    int[] stack;
    int top;
    int capacity;

    // Constructor
    public StackUsingArray(int size) {
        stack = new int[size];
        capacity = size;
        top = -1; // stack is empty
    }

    // Push
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow!");
            return;
        }
        stack[++top] = data;
    }

    // Pop
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        return stack[top--];
    }

    // Peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return -1;
        }
        return stack[top];
    }

    // isEmpty
    public boolean isEmpty() {
        return top == -1;
    }

    // isFull
    public boolean isFull() {
        return top == capacity - 1;
    }

    // Print stack
    public void printStack() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    // Main
    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack(); // 30 20 10

        System.out.println("Popped: " + stack.pop()); // 30
        System.out.println("Peek: " + stack.peek());  // 20
        stack.printStack(); // 20 10
    }
}

/*

30 20 10
Popped: 30
Peek: 20
20 10

 */

/*

Stack Using Array
Concept:
Use a fixed-size array.
Maintain a top index to track the top of the stack.
Stack grows from index 0 to size - 1.

Key Operations:
push(int data)
pop()
peek()
isEmpty()
isFull()

 */