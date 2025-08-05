package Stack_DSA;


class Node1<T> {
    T data;
    Node1<T> next;

    Node1(T data) {
        this.data = data;
        this.next = null;
    }
}

class GenericStack<T> {
    private Node1<T> top;

    public void push(T data) {
        Node1<T> newNode = new Node1<>(data);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (isEmpty()) throw new RuntimeException("Stack Underflow");
        T val = top.data;
        top = top.next;
        return val;
    }

    public T peek() {
        if (isEmpty()) throw new RuntimeException("Stack is Empty");
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        Node1<T> temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class GenericStackMain {
    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();
        stack.push("Java");
        stack.push("Python");
        stack.push("DSA");

        stack.printStack(); // DSA Python Java
        System.out.println("Popped: " + stack.pop()); // DSA
        System.out.println("Peek: " + stack.peek());  // Python
    }
}

/*
DSA Python Java
Popped: DSA
Peek: Python
 */