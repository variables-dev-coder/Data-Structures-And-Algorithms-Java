package Stack_DSA;

// Stack Using LinkedList

//Concept:
//Each node holds data and a reference to the next node.
//
//top refers to the top node in the stack.


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackUsingLinkedList {
    Node top;

    // Push
    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    // Pop
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow!");
            return -1;
        }
        int popped = top.data;
        top = top.next;
        return popped;
    }

    // Peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!");
            return -1;
        }
        return top.data;
    }

    // isEmpty
    public boolean isEmpty() {
        return top == null;
    }

    // Print Stack
    public void printStack() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main
    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        stack.push(100);
        stack.push(200);
        stack.push(300);

        stack.printStack(); // 300 200 100

        System.out.println("Popped: " + stack.pop()); // 300
        System.out.println("Peek: " + stack.peek());  // 200

        stack.printStack(); // 200 100
    }
}

/*
300 200 100
Popped: 300
Peek: 200
200 100 300 200 100
Popped: 300
Peek: 200
200 100

 */

/*

| Feature      | Array-based Stack      | LinkedList-based Stack     |
| ------------ | ---------------------- | -------------------------- |
| Size Limit   | Fixed (unless dynamic) | Dynamic (no limit)         |
| Memory Usage | Compact                | Slightly more (node links) |
| Performance  | Fast                   | Slight overhead            |


 */