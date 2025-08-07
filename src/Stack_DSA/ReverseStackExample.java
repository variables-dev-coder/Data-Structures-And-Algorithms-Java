package Stack_DSA;

// Reverse a Stack Recursively
//Problem:
//Reverse the elements of a stack using recursion only.
//Logic:
//Use recursion to pop elements one by one.
//Then insert them at bottom recursively.


import java.util.Stack;

public class ReverseStackExample {

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return;
        int top = stack.pop();
        reverse(stack);
        insertAtBottom(stack, top);
    }

    private static void insertAtBottom(Stack<Integer> stack, int item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        int top = stack.pop();
        insertAtBottom(stack, item);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1); s.push(2); s.push(3);
        reverse(s);
        System.out.println(s); // [1, 2, 3] → becomes [3, 2, 1]
    }
}


/*
Dry Run:
Initial Stack: [1, 2, 3]
Pop 3, reverse([1,2])
Pop 2, reverse([1])
Pop 1, reverse([])
Insert 1 at bottom → [1]
Insert 2 at bottom → [2, 1]
Insert 3 at bottom → [3, 2, 1]
 */