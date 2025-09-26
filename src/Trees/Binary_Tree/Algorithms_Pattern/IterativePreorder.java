package Trees.Binary_Tree.Algorithms_Pattern;

// Iterative DFS (Preorder Traversal)

import java.util.Stack;

class Node2 {
    int val;
    Node2 left, right;

    Node2(int v) {
        val = v;
        left = right = null;
    }
}

public class IterativePreorder {

    static void preorder(Node2 root) {
        if (root == null) return;

        Stack<Node2> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node2 curr = stack.pop();
            System.out.print(curr.val + " ");

            // Push right child first so left is processed first
            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);
        }
    }

    public static void main(String[] args) {
        /*
              1
             / \
            2   3
           / \
          4   5
        */

        Node2 root = new Node2(1);
        root.left = new Node2(2);
        root.right = new Node2(3);
        root.left.left = new Node2(4);
        root.left.right = new Node2(5);

        System.out.print("Preorder (iterative): ");
        preorder(root); // Expected: 1 2 4 5 3
    }
}

/*

Dry Run

Tree:

        1
       / \
      2   3
     / \
    4   5


1.Push root 1.
    Stack = [1]

2.Pop 1 → print 1. Push right(3), then left(2).
    Stack = [3, 2]
    Output = 1

3.Pop 2 → print 2. Push right(5), then left(4).
    Stack = [3, 5, 4]
    Output = 1 2

4.Pop 4 → print 4. No children.
    Stack = [3, 5]
    Output = 1 2 4

5.Pop 5 → print 5. No children.
    Stack = [3]
    Output = 1 2 4 5

6.Pop 3 → print 3.
    Stack = []
    Output = 1 2 4 5 3

Output
Preorder (iterative): 1 2 4 5 3

 */